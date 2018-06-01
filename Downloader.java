// Created by Kaleab Belete
// This is the code for downloading and uploading audio files from firebase
// The download function should be initiated once the transaction has been processed and confirmed (as per my previous commit)

public class Downloader {
    private StorageReference mStorage;

    public Downloader() {}

    private void startDownload(String song_name) {
        StorageReference song_ref = httpsReference.child("songs/" + song_name + ".mp3");
        File localFile = File.createTempFile(song_name, ".mp3");
        song_ref.getFile(localFile).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                // local temp file has been created
            }
        }).addFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                // handle errors
            }
        });
    }
}