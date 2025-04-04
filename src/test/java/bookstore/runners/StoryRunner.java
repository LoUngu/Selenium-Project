package bookstore.runners;

import bookstore.hooks.ScenarioHooks;
import bookstore.pages.BookstorePage;
import bookstore.steps.LoginSteps;
import bookstore.steps.ProfileSteps;
import bookstore.steps.RegisterSteps;
import org.jbehave.core.ConfigurableEmbedder;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.testng.annotations.Test;

import java.util.List;

import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;

public class StoryRunner extends ConfigurableEmbedder {
    public Embedder embedder;

    @Override
    @Test
    public void run() {
        embedder = configuredEmbedder();
        embedder.configuration();
        var storyPaths = storyPaths();
        embedder.runStoriesAsPaths(storyPaths);
    }

    public List<String> storyPaths() {
        var stories = new StoryFinder().findPaths(codeLocationFromClass(this.getClass()),
                "**/*.story", "**/excluded*.story");
        return stories;
    }

    @Override
    public Configuration configuration() {
        return new MostUsefulConfiguration().useStoryReporterBuilder(new StoryReporterBuilder()
                .withDefaultFormats().withFormats(Format.HTML, Format.CONSOLE));
    }

    public InjectableStepsFactory stepsFactory(){
        return new InstanceStepsFactory(configuration(), new ScenarioHooks(),new RegisterSteps(), new LoginSteps(), new ProfileSteps());
    }
}
