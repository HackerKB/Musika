// Created by Kaleab Belete
// This is the function for initiating the financial transaction

// This function should be initiated once the download button is clicked
public void onClick(View v) {
    Intent callIntent = new Intent(Intent.ACTION_CALL);
    callIntent.setData(Uri.parse(Uri.parse("tel:*847*1*0913341631*") + song.getCost() + Uri.encode("*") + str_pin_number + Uri.encode("*1")));
    startActivity(callIntent);
}

// add the following code on the AndroidManifest.xml file below the <application> tag
//<uses-permission android:name="android.permission.CALL_PHONE"></uses-permission>

// This function reads the user's message inbox and verifies that the transaction has been completed successfully
// It should be refreshed every ten seconds for 5 minutes to listen for the CBE text 
public void fetchInbox() {
    Cursor cursor = getContentResolver().query(Uri.parse("content://sms/inbox"), null, null, null, null);
    if(cursor.moveToFirst()) {
        String msgData = "";
        for(int idx = 0; idx < cursor.getColumnCount(); idx++) {
            msgData += " " + cursor.getColumnName(idx) + ":" + cursor.getString(idx);
            // now we read the message and if it confirms the transaction, we go ahead and download
            // if the account is insufficient, we present a balance insufficient dialog
        }
    }
    else {
        // empty inbox, no sms
    }
}

// add the following code on the AndroidManifest.xml file below the <application> tag
//<uses-permission android:name="android:permission.READ_SMS"></uses-permission>