package android.rnu.iit.sharedcontentproviderapp;

import android.net.Uri;

/**
 * Created by wael on 08/11/15.
 */
public class RecordsTable {

    // Records database table
    public static final String TABLE_RECORDS = "records";

    // table records fields

    public static final String _ID = "_id";
    public static final String LABEL = "title";
    public static final String DESCRIPTION = "description";
    public static final String[] PROJECTION_ALL = { _ID,LABEL, DESCRIPTION};

    // info for content provider

    private static final String AUTHORITY = "tn.droidcon.testprovider.provider" ;
    public static final Uri RECORDS_CONTENT_URI = Uri.parse("content://"
            + AUTHORITY + "/" + RecordsTable.TABLE_RECORDS);

}
