package extension;

import java.util.Optional;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

class logWatcher implements TestWatcher {

    public void testSuccessful(ExtensionContext context) {

        System.out.println("Test Success");
    }

    public void testFailed(ExtensionContext context, Throwable cause) {

        System.out.println("Test Failed");
    }
}
