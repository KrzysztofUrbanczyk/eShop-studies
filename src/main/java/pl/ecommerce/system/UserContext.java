package pl.ecommerce.system;

public interface UserContext {
    void authorize(String userId);

    CurrentUser getCurrentUser();
}
