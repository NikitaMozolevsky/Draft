package by.mozolevskij.pharmacy.example.sql_hibernate_additional.hibernate_N1;

import org.hibernate.query.Query;

import java.util.List;

public class Theory {

    /**
     *
     * fetch = FetchType.EAGER - для сущностей по умолчанию
     * при выполнении запроса с анноацией @ManyToOne если мы пытаемся
     * получить из базы обхект на которого ссылается другой, то мы
     * получаем и ссылающийся объект, соответственно, если мы пытаемся получить
     * несколько объектов, то для каждого из них будет вызываться отдельный
     * SELECT
     *
     * fetch = FetchType.LAZY - не достает ссылающийся на этот объект
     * объект, соответственно не трудозатратный,
     *
     * Если все-таки понадобится Topic нашего Comment, и понадобится
     * для каждого Comment, то вместо отдельного вызова каждого Topic
     * можно записать JOIN FETCH, который преобразуется SQL в обычный
     * INNER JOIN, соответственно мы делаем только один запрос
     * тем самым решая проблему N+1
     * HibernateUtil.doInHibernate(session -> {
     *         Query<Comment> query = session.createQuery
     *              ("select c from Comment c join fetch c.topic t",
     *              Comment.class);
     *         List<Comment> comments = query.getResultList();
     *
     *
     * */

    /*public void whenJoinFetch_thenNoProblem() {
        HibernateUtil.doInHibernate(session -> {
            Query<Comment> query = session.createQuery("select c from Comment c join fetch c.topic t", Comment.class);
            List<Comment> comments = query.getResultList();
            Assertions.assertEquals(5, comments.size());
            comments.forEach(comment -> System.out.println(comment.getText() + " " + comment.getTopic().getTitle()));
        });
    }*/

}

