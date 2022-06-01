package java_base_annotations.dbexp;

public @interface Uniqueness {
    Constraints constraints()
            default @Constraints(unique = true);
}
