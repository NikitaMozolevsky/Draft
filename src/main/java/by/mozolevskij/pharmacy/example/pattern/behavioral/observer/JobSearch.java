package by.mozolevskij.pharmacy.example.pattern.behavioral.observer;

public class JobSearch {
    public static void main(String[] args) {
        JavaDeveloperJobSite jobSite = new JavaDeveloperJobSite();

        jobSite.addVacancy("job1");
        jobSite.addVacancy("job2");

        Observer subscriber1 = new Subscriber("Nikita");
        Observer subscriber2 = new Subscriber("NikitaB");

        jobSite.addObserver(subscriber1);
        jobSite.addObserver(subscriber2);

        jobSite.addVacancy("job3");

        jobSite.removeVacancy("job3");
    }
}
