package com.example.menuwithtoolbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    Button button;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar=findViewById(R.id.toolbar);
        button=findViewById(R.id.btn);
        imageView=findViewById(R.id.img);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final PopupMenu popupMenu=new PopupMenu(MainActivity.this,button);
                popupMenu.getMenuInflater().inflate(R.menu.popup_menu,popupMenu.getMenu());
                popupMenu.show();
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(MainActivity.this,"you pressed "+item.getTitle(),Toast.LENGTH_LONG).show();
                        return true;
                    }
                });

            }
        });









        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
         registerForContextMenu(imageView);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu,menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        Toast.makeText(MainActivity.this,"you pressed "+item.getTitle(),Toast.LENGTH_LONG).show();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        Toast.makeText(MainActivity.this,"you pressed "+item.getTitle(),Toast.LENGTH_LONG).show();
        return super.onContextItemSelected(item);

    }
}
