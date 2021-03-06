package com.allantl.jira4s

import com.allantl.jira4s.auth.{ApiToken, BasicAuthentication}
import com.allantl.jira4s.v2.JiraSingleTenantClient
import com.softwaremill.sttp.HttpURLConnectionBackend
import org.specs2.mutable.Specification

class JiraSingleTenantClientSpec extends Specification {

  "JiraSingleTenantClient" should {
    "initialize with api token" in {
      implicit val backend = HttpURLConnectionBackend()

      val apiToken = ApiToken("https://www.jira.atlassian.net", "user@gmail.com", "apiToken")
      val clientWithApiToken = JiraSingleTenantClient(apiToken)

      clientWithApiToken must not(throwA[Exception])
    }

    "initialize with basic authentication" in {
      implicit val backend = HttpURLConnectionBackend()

      val basicCredentials = BasicAuthentication("https://www.jira.atlassian.net", "user", "pass")
      val clientWithBasicCredentials = JiraSingleTenantClient(basicCredentials)

      clientWithBasicCredentials must not(throwA[Exception])
    }
  }
}
