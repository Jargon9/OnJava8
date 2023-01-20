package java_base.annotations.dbexp;

public @interface Uniqueness {
    Constraints constraints()
            default @Constraints(unique = true);
}
