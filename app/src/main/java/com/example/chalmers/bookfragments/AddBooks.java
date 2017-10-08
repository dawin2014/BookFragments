package com.example.chalmers.bookfragments;

import android.icu.text.AlphabeticIndex;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddBooks extends AppCompatActivity {
    EditText titleInput;
    EditText authorInput;
    EditText priceInput;
    EditText isbnInput;
    EditText courseInput;
    BookManager bookManager;
    Button saveButton;
    Book book;
    String titleInputText;
    String authorInputText;
    String priceInputText;
    String isbnInputText;
    String courseInputText;
    boolean result;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        try{
        super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_add_books);
        saveButton = (Button) findViewById(R.id.saveButton);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                titleInput = (EditText) findViewById(R.id.titleValue);
                titleInputText = titleInput.getText().toString();
                authorInput = (EditText) findViewById(R.id.authorValue);
                priceInput = (EditText) findViewById(R.id.priceValue);
                String priceInputText = priceInput.getText().toString();
                isbnInput = (EditText) findViewById(R.id.isbnValue);
                isbnInputText = isbnInput.getText().toString();
                authorInputText = authorInput.getText().toString();
                courseInput = (EditText) findViewById(R.id.courseValue);
                courseInputText = courseInput.getText().toString();

                if (titleInputText.matches("")) {
                    Toast.makeText(getBaseContext(), "You did not enter the title", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (authorInputText.matches("")) {
                    Toast.makeText(getBaseContext(), "You did not enter the author name", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (priceInputText.matches("")) {
                    Toast.makeText(getBaseContext(), "You did not enter the price", Toast.LENGTH_SHORT).show();
                    return;
                }else if (!tryParseInt(priceInputText))
                {
                    Toast.makeText(getBaseContext(), "You did not enter the price in Integer", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (isbnInputText.matches("")) {
                    Toast.makeText(getBaseContext(), "You did not enter the ISBN", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (courseInputText.matches("")) {
                    Toast.makeText(getBaseContext(), "You did not enter the course", Toast.LENGTH_SHORT).show();
                    return;
                }

                book = bookManager.getInstance().createBook(authorInputText,titleInputText,Integer.parseInt(priceInputText),isbnInputText,courseInputText);
                result = bookManager.getInstance().saveChanges(book, getBaseContext());
                if (result == false) {
                    Toast.makeText(getBaseContext(), "Could not save book", Toast.LENGTH_SHORT).show();
                    return;
                }
                else
                    Toast.makeText(getBaseContext(), "The book has been saved", Toast.LENGTH_SHORT).show();
            }
        });
        }
        catch (Exception e){
            e.printStackTrace();
            Log.d("setText Exception:",e.toString());
        }
    }
    boolean tryParseInt(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

