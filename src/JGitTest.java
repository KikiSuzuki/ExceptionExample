import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;

import java.io.File;
import java.io.IOException;

public class JGitTest {
    public static void main(String[] args) throws GitAPIException, IOException {
        System.out.println("adding");
        Git git = Git.open(new File(".git"));

        git.add()
                .addFilepattern("resultsFile.html")
                .call();
        System.out.println("commiting");
        git.commit()
                .setAll(true)
                .setMessage("Update results")
                .call();
        System.out.println("remote adding");
        git.push()
                .setRemote("https://github.com/KikiSuzuki/ExceptionExample.git")
                .setCredentialsProvider(
                        new UsernamePasswordCredentialsProvider("skultrix", "")
                        )
                        .call();
    }
}
