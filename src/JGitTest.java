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
                //.setRemote("https://github.com/KikiSuzuki/ExceptionExample.git")
                .setCredentialsProvider(
                        new UsernamePasswordCredentialsProvider("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", "")
                        )
                        .call();
    }
}
