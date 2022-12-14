package com.example.lab1;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class DataUtilities extends Activity {
    public static void writeToFile(String content, Context context) {
        File path = context.getFilesDir();
        try {
            FileOutputStream writer = new FileOutputStream(new File(path, "data.txt"));
            writer.write(content.getBytes(StandardCharsets.UTF_8));
            writer.close();
            Toast.makeText(context, "Wrote to file: "+path, Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static String readFromFile(Context context) {
        File path = context.getFilesDir();
        File readFrom = new File(path, "data.txt");
        byte[] content = new byte[(int) readFrom.length()];
        try {
            FileInputStream stream = new FileInputStream(readFrom);
            stream.read(content);
            return new String(content);
        } catch (Exception e) {
            e.printStackTrace();
            return e.toString();
        }

    }
}
