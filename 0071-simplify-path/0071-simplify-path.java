import java.nio.file.*;

class Solution {
    public String simplifyPath(String path) {
        Path p = Paths.get(path);
        return p.normalize().toString();
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna