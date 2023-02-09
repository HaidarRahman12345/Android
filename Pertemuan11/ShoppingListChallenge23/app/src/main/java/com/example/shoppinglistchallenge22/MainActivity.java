package com.example.shoppinglistchallenge22;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import
        com.example.shoppinglistchallenge22.databinding.ActivityMainBinding;
public class MainActivity extends AppCompatActivity {
    private int mTextViewCount = 0;
    private ActivityMainBinding mainBinding;
    private TextView[] mTextView;
    private Object ItemListActivity;
    private final ActivityResultLauncher<Intent> mAddShoppingList =
            registerForActivityResult(new
                            ActivityResultContracts.StartActivityForResult(),
                    result -> {
                        if (result.getResultCode() == RESULT_OK) {
                            Intent intent = result.getData();
                            String item =
                                    intent.getStringExtra(ItemListActivity.ITEM_TAG);
                            mTextView[mTextViewCount].setText(item);
                            mTextViewCount++;
                            if (mTextViewCount == 9) {
                                mainBinding.addItem.setEnabled(false);
                            }
                        }
                    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());
        mTextView = new TextView[]{
                mainBinding.textView,
                mainBinding.textView2,
                mainBinding.textView3,
                mainBinding.textView4,
                mainBinding.textView5,
                mainBinding.textView6,
                mainBinding.textView7,
                mainBinding.textView8,
                mainBinding.textView9,
        };
        mainBinding.addItem.setOnClickListener(v -> {
            Intent intent = new Intent(this, ItemListActivity.class);
            mAddShoppingList.launch(intent);
        });
        if (savedInstanceState != null) {
            String[] tv = savedInstanceState.getStringArray("item_list");
            mTextViewCount = tv.length - 1;
            for (int i = 0; i <= mTextViewCount; i++)
                mTextView[i].setText(tv[i]);

            mainBinding.addItem.setEnabled(savedInstanceState.getBoolean("addItem_disabled"));
        }
    }
}
