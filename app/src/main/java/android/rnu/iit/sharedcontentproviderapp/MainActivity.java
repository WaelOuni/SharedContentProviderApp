package android.rnu.iit.sharedcontentproviderapp;

import android.content.ContentResolver;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.rnu.iit.sharedcontentproviderapp.adapter.TodoCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ContentResolver contentResolver =   getContentResolver();
        final String  selection   =       null;
        final String[]    selecArguments= null;

        final Cursor  cursor=contentResolver.query(RecordsTable.RECORDS_CONTENT_URI, RecordsTable.PROJECTION_ALL, selection, selecArguments, null);

        final ListView lvItems = (ListView) findViewById(R.id.listView);
// Setup cursor adapter using cursor from last step
        final TodoCursorAdapter todoAdapter = new TodoCursorAdapter(this, cursor);
// Attach cursor adapter to the ListView
        lvItems.setAdapter(todoAdapter);
        lvItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    contentResolver.delete(RecordsTable.RECORDS_CONTENT_URI,"_id="+id,selecArguments);
                todoAdapter.swapCursor(contentResolver.query(RecordsTable.RECORDS_CONTENT_URI, RecordsTable.PROJECTION_ALL, selection, selecArguments, null));
                todoAdapter.notifyDataSetChanged();
            }
        });

    }
}
