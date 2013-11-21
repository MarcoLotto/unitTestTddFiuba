package TP2;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * TestSuite Es lo que implementa el cliente para ejecutar una serie de tests.
 * Debe hacer que sus tests sean ejecutados dentro del metodo init().
 **/

public abstract class TestSuite implements Testeable {

	private String name;
	private String packageName;
	private String pattern;
	private Fixture fixture;
	private List<TestSuite> testSuites;
	private List<Test> tests;
	private List<String> tagsToSearch;
	protected List<String> testsToSkip;
	private RunMode runMode;

	public TestSuite() {
		setName(name);
		packageName = "";
		pattern = ".*";
		fixture = new Fixture();
		testSuites = new LinkedList<TestSuite>();
		tests = new LinkedList<Test>();
		tagsToSearch = new LinkedList<String>();
		testsToSkip = new LinkedList<String>();
	}

	public TestSuite(String name) {
		setName(name);
		packageName = "";
		pattern = ".*";
		fixture = new Fixture();
		testSuites = new LinkedList<TestSuite>();
		tests = new LinkedList<Test>();
		tagsToSearch = new LinkedList<String>();
		testsToSkip = new LinkedList<String>();
	}

	public void setName(String name) {
		this.name = name;
		if (getPackageName() == "") {
			setPackageName(name);
		}
	}

	public String getName() {
		return name;
	}

	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	public void setRunMode(RunMode runMode) {
		this.runMode = runMode;
	}

	protected abstract void init();

	public void run() {
		Reporter reporter = this.prepairTestSuites();
		for (Test test : tests) {
			this.runParticularTest(reporter, test);
		}
		suiteTearDown();
	}

	/**
	 * Se corren solo los test que hayan fallado anteriormente
	 */
	public void runFailed() {
		Reporter reporter = this.prepairTestSuites();
		for (Test test : tests) {
			Result result = test.getResult();
			if (result != null && (!result.getState().equals(ResultType.Ok))) {
				this.runParticularTest(reporter, test);
			}
		}
		suiteTearDown();
	}

	/**
	 * Se corren solo los test que nunca se hayan corrido
	 */
	public void runNotTested() {
		Reporter reporter = this.prepairTestSuites();
		for (Test test : tests) {
			Result result = test.getResult();
			if (result == null) {
				this.runParticularTest(reporter, test);
			}
		}
		suiteTearDown();
	}

	private Reporter prepairTestSuites() {
		suiteSetUp();
		Reporter reporter = Reporter.getReporter();
		for (TestSuite t : testSuites) {
			if (isTestInPattern(t)) {
				t.init();
				t.addFixture(getFixture());
				t.setPattern(getPattern());
				t.copySkippedTests(this);
				t.run();
			}
		}
		return reporter;
	}

	private void runParticularTest(Reporter reporter, Test t) {
		setUp();
		Date before = new Date();
		if (!(testsToSkip.contains(t.getName())) && isTestInPattern(t)
				&& testWithAnyTag(t)) {
			try {
				t.setFixture(getFixture());
				t.run();
				t.setResult(new ResultOk(t.getName(), getPackageName(),
						TimerUtils.calculateTimeInSeconds(before)));

			} catch (AssertFailedException e) {
				t.setResult(new ResultFail(t.getName(), getPackageName(),
						TimerUtils.calculateTimeInSeconds(before), e
								.getMessage()));
			} catch (Exception e) {
				t.setResult(new ResultError(t.getName(), getPackageName(),
						TimerUtils.calculateTimeInSeconds(before), e
								.getMessage()));
			} finally {
				reporter.addResult(t);
				tearDown();
			}
		}
	}

	private boolean testWithAnyTag(Test t) {
		if (tagsToSearch.size() == 0) {
			return true;
		}

		for (String tag : tagsToSearch) {
			if (t.hasTag(tag)) {
				return true;
			}
		}
		return false;
	}

	public void addFixture(Fixture fixture) {
		this.fixture.addFixture(fixture);
	}

	public Fixture getFixture() {
		return fixture;
	}

	private boolean isTestInPattern(Testeable t) {
		return t.getName().matches(getPattern());
	}

	protected void setUp() {
	}

	protected void tearDown() {
	}

	protected void suiteSetUp() {
	}

	protected void suiteTearDown() {
	}

	public String toString() {
		return getName();
	}

	private void checkNameInList(String name, List<?> list) {
		for (Object t : list) {
			if (t.toString().equals(name)) {
				throw new TestAlreadyAddedException();
			}
		}
	}

	protected void addTest(TestSuite testSuite) {
		checkNameInList(testSuite.getName(), testSuites);
		testSuite.setPackageName(packageName);
		testSuites.add(testSuite);
	}

	public List<TestSuite> getTestSuites() {
		return testSuites;
	}

	protected void addTest(Test test) {
		checkNameInList(test.getName(), tests);
		tests.add(test);
	}

	public List<Test> getTests() {
		return this.tests;
	}

	public void setPackageName(String packageName) {
		String dot = "";
		if (this.packageName != "") {
			dot = ".";
		}
		this.packageName = packageName + dot + this.packageName;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setTag(String tag) {
		tagsToSearch.add(tag);
	}

	public void skipTest(String testName) {
		testsToSkip.add(testName);
	}

	protected void copySkippedTests(TestSuite parent) {
		for (String testName : parent.testsToSkip) {
			testsToSkip.add(testName);
		}
	}

}
