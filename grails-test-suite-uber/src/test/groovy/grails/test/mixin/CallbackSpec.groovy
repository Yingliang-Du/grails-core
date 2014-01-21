package grails.test.mixin

import grails.test.mixin.support.GrailsUnitTestMixin
import spock.lang.Specification

/**
 * @author Lari Hotari
 */
@TestMixin(GrailsUnitTestMixin)
class CallbackSpec extends Specification {
    def doWithSpring = {
        myService(MyService)
    }
    
    def doWithConfig(c) {
        c.myConfigValue = 'Hello'    
    }

    def "doWithSpring callback is executed"() {
        expect:
        grailsApplication.mainContext.getBean('myService') != null
    }
    
    def "doWithConfig callback is executed"(){
        expect:
        config.myConfigValue == 'Hello'
    }
}