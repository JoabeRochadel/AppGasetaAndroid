package devandroid.joabe.appgaseta.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

import devandroid.joabe.appgaseta.R;
import devandroid.joabe.appgaseta.controller.PersonController;
import devandroid.joabe.appgaseta.controller.RequestedCourseController;
import devandroid.joabe.appgaseta.model.Person;

public class MainActivity extends AppCompatActivity {

    public static final String NAME_PREFERENCES = "pref_listavip";
    PersonController personController;
    RequestedCourseController requestedCourseController;
    List<String> CoursesNames;
    Person person;
    EditText editFirstName;
    EditText editSecondName;
    EditText editCourse;
    EditText editContact;
    Button buttonClean;
    Button buttonSave;
    Button buttonFinish;

    Spinner spinnerListCourse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_spinner);
        personController = new PersonController(MainActivity.this);
        requestedCourseController = new RequestedCourseController();
        person = new Person();
        personController.Find(person);

        CoursesNames = requestedCourseController.dataForSpinner();

        editFirstName = findViewById(R.id.editFirstName);
        editSecondName = findViewById(R.id.editSecondName);
        editCourse = findViewById(R.id.editCourse);
        editContact = findViewById(R.id.editContact);

        spinnerListCourse = findViewById(R.id.spinner);

        buttonClean = findViewById(R.id.buttonClean);
        buttonSave = findViewById(R.id.buttonSave);
        buttonFinish = findViewById(R.id.buttonFinish);

        editFirstName.setText(person.getName());
        editSecondName.setText(person.getSecondName());
        editCourse.setText(person.getNameCourse());
        editContact.setText(person.getNumberContact());

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,
                                        requestedCourseController.dataForSpinner());
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);

        spinnerListCourse.setAdapter(adapter);

        buttonClean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editFirstName.setText("");
                editSecondName.setText("");
                editCourse.setText("");
                editContact.setText("");

                personController.Clean();
            }
        });

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                person.setName(editFirstName.getText().toString());
                person.setSecondName(editSecondName.getText().toString());
                person.setNumberContact(editContact.getText().toString());
                person.setNameCourse(editCourse.getText().toString());

                personController.Save(person);
            }
        });

        buttonFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Volte Sempre!", Toast.LENGTH_LONG).show();

            }
        });
    }
}