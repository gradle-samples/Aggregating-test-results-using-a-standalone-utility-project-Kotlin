plugins {
    base
    id("test-report-aggregation")
}

dependencies {
    testReportAggregation(project(":application")) // <.>
}

reporting {
    reports {
        val testAggregateTestReport by creating(AggregateTestReport::class) { // <.>
            testType.set(TestSuiteType.UNIT_TEST)
        }
    }
}

tasks.check {
    dependsOn(tasks.named<TestReport>("testAggregateTestReport")) // <.>
}
