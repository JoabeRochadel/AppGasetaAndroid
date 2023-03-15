package devandroid.joabe.appgaseta.controller;

import java.util.ArrayList;
import java.util.List;

import devandroid.joabe.appgaseta.model.RequestedCourse;

public class RequestedCourseController {

    private List listRequestedCourses;

    public List getListCourses(){

        listRequestedCourses = new ArrayList<RequestedCourse>();

        listRequestedCourses.add(new RequestedCourse("Java iniciante"));
        listRequestedCourses.add(new RequestedCourse("Java para Web"));
        listRequestedCourses.add(new RequestedCourse("Java para mobile"));
        listRequestedCourses.add(new RequestedCourse("C# iniciante"));
        listRequestedCourses.add(new RequestedCourse("C# para Web"));
        listRequestedCourses.add(new RequestedCourse("C# para DataScience"));
        listRequestedCourses.add(new RequestedCourse("Python iniciante"));
        listRequestedCourses.add(new RequestedCourse("Python para DataScience"));
        listRequestedCourses.add(new RequestedCourse("Python para Web"));
        listRequestedCourses.add(new RequestedCourse("Iniciante Front-end"));
        listRequestedCourses.add(new RequestedCourse("HTML, css e JavaScript"));
        listRequestedCourses.add(new RequestedCourse("React JS"));

        return listRequestedCourses;
    }

    public ArrayList<String> dataForSpinner(){

        ArrayList<String> data = new ArrayList<>();

        for (int i = 0; i < getListCourses().size(); i++ ){
            RequestedCourse requestedCourse = (RequestedCourse) getListCourses().get(i);
            data.add(requestedCourse.getNameRequestedCourse());
        }
        return data;
    }
}
