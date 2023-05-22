package by.mozolevskij.pharmacy.example.spring.spring_theory.security;

public class PreAuthorize {

    /**
     *
     * ConfigClassSS - add annotation @EnableGlobalMethodSecurity(prePostEnabled = true)
     * Service class {
     * @PreAuthorize("hasRole('ROLE_ADMIN')") - будет проверять есть ли у пользователя
     * такая роль, если да - то работает
     * public void method() {
     *     sout("something")
     * }
     * }
     *
     * @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('SOME_ROLE')")
     * - будет проверять есть ли у пользователя
     *      * такая роль или другая
     *      * public void method() {
     *      *     sout("something")
     *      * }
     *      * }
     * */

}
