package hayen.com.practices;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AutoCompleteText extends AppCompatActivity {

    @BindView(R.id.auto_complete_text)
    AutoCompleteTextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_complete_text);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,getBrandList());
        text.setAdapter(adapter);


    }

    private String[] getBrandList()
    {
        return new String[]{"Gucci","Sikko","Nike","Adidas","Zara","Intel","Aksesuar","Mavi","Yesil","OOoooOO","Tirt"
                ,"Zirt","Pirt","Tamamla","Zilgit","Zikkim","ZIKKKOOOO","Sikko","Nike","Adidas","Zara","Intel","Aksesuar","Mavi","Yesil","OOoooOO","Tirt"
                ,"Zirt","Pirt","Tamamla","Zilgit","Zikkim","ZIKKKOOOO","Sikko","Nike","Adidas","Zara","Intel","Aksesuar","Mavi","Yesil","OOoooOO","Tirt"
                ,"Zirt","Pirt","Tamamla","Zilgit","Zikkim","ZIKKKOOOO","Sikko","Nike","Adidas","Zara","Intel","Aksesuar","Mavi","Yesil","OOoooOO","Tirt"
                ,"Zirt","Pirt","Tamamla","Zilgit","Zikkim","ZIKKKOOOO","Sikko","Nike","Adidas","Zara","Intel","Aksesuar","Mavi","Yesil","OOoooOO","Tirt"
                ,"Zirt","Pirt","Tamamla","Zilgit","Zikkim","ZIKKKOOOO","Sikko","Nike","Adidas","Zara","Intel","Aksesuar","Mavi","Yesil","OOoooOO","Tirt"
                ,"Zirt","Pirt","Tamamla","Zilgit","Zikkim","ZIKKKOOOO","Sikko","Nike","Adidas","Zara","Intel","Aksesuar","Mavi","Yesil","OOoooOO","Tirt"
                ,"Zirt","Pirt","Tamamla","Zilgit","Zikkim","ZIKKKOOOO","Sikko","Nike","Adidas","Zara","Intel","Aksesuar","Mavi","Yesil","OOoooOO","Tirt"
                ,"Zirt","Pirt","Tamamla","Zilgit","Zikkim","ZIKKKOOOO","Sikko","Nike","Adidas","Zara","Intel","Aksesuar","Mavi","Yesil","OOoooOO","Tirt"
                ,"Zirt","Pirt","Tamamla","Zilgit","Zikkim","ZIKKKOOOO","Sikko","Nike","Adidas","Zara","Intel","Aksesuar","Mavi","Yesil","OOoooOO","Tirt"
                ,"Zirt","Pirt","Tamamla","Zilgit","Zikkim","ZIKKKOOOO","Sikko","Nike","Adidas","Zara","Intel","Aksesuar","Mavi","Yesil","OOoooOO","Tirt"
                ,"Zirt","Pirt","Tamamla","Zilgit","Zikkim","ZIKKKOOOO","Sikko","Nike","Adidas","Zara","Intel","Aksesuar","Mavi","Yesil","OOoooOO","Tirt"
                ,"Zirt","Pirt","Tamamla","Zilgit","Zikkim","ZIKKKOOOO","Sikko","Nike","Adidas","Zara","Intel","Aksesuar","Mavi","Yesil","OOoooOO","Tirt"
                ,"Zirt","Pirt","Tamamla","Zilgit","Zikkim","ZIKKKOOOO","Sikko","Nike","Adidas","Zara","Intel","Aksesuar","Mavi","Yesil","OOoooOO","Tirt"
                ,"Zirt","Pirt","Tamamla","Zilgit","Zikkim","ZIKKKOOOO","Sikko","Nike","Adidas","Zara","Intel","Aksesuar","Mavi","Yesil","OOoooOO","Tirt"
                ,"Zirt","Pirt","Tamamla","Zilgit","Zikkim","ZIKKKOOOO","Sikko","Nike","Adidas","Zara","Intel","Aksesuar","Mavi","Yesil","OOoooOO","Tirt"
                ,"Zirt","Pirt","Tamamla","Zilgit","Zikkim","ZIKKKOOOO","Sikko","Nike","Adidas","Zara","Intel","Aksesuar","Mavi","Yesil","OOoooOO","Tirt"
                ,"Zirt","Pirt","Tamamla","Zilgit","Zikkim","ZIKKKOOOO","Sikko","Nike","Adidas","Zara","Intel","Aksesuar","Mavi","Yesil","OOoooOO","Tirt"
                ,"Zirt","Pirt","Tamamla","Zilgit","Zikkim","ZIKKKOOOO","Sikko","Nike","Adidas","Zara","Intel","Aksesuar","Mavi","Yesil","OOoooOO","Tirt"
                ,"Zirt","Pirt","Tamamla","Zilgit","Zikkim","ZIKKKOOOO","Sikko","Nike","Adidas","Zara","Intel","Aksesuar","Mavi","Yesil","OOoooOO","Tirt"
                ,"Zirt","Pirt","Tamamla","Zilgit","Zikkim","ZIKKKOOOO","Sikko","Nike","Adidas","Zara","Intel","Aksesuar","Mavi","Yesil","OOoooOO","Tirt"
                ,"Zirt","Pirt","Tamamla","Zilgit","Zikkim","ZIKKKOOOO","Sikko","Nike","Adidas","Zara","Intel","Aksesuar","Mavi","Yesil","OOoooOO","Tirt"
                ,"Zirt","Pirt","Tamamla","Zilgit","Zikkim","ZIKKKOOOO","Sikko","Nike","Adidas","Zara","Intel","Aksesuar","Mavi","Yesil","OOoooOO","Tirt"
                ,"Zirt","Pirt","Tamamla","Zilgit","Zikkim","ZIKKKOOOO","Sikko","Nike","Adidas","Zara","Intel","Aksesuar","Mavi","Yesil","OOoooOO","Tirt"
                ,"Zirt","Pirt","Tamamla","Zilgit","Zikkim","ZIKKKOOOO"};
    }


}
