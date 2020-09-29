/*
 * Copyright (C) 2014 Square, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package mytest

import java.io.IOException
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.AfterAll
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.By
import org.openqa.selenium.Keys

class SeleniumhqTest {

  @Test
  fun `test ok http should return google request with no problem`() {
    try {
      SeleniumhqTest.webdriver.get( "http://www.google.de/" );
    } finally {}
    val url = SeleniumhqTest.webdriver.getCurrentUrl()
    val title = SeleniumhqTest.webdriver.getTitle()
    val searchBox = SeleniumhqTest.webdriver.findElement(By.name("q"))
    searchBox.sendKeys("webdriver" + Keys.ENTER)

    Assertions.assertTrue(title.contains("Google"))
    Assertions.assertTrue(url.contains("google"))
    Thread.sleep(8000L)
  }
  companion object {
    private var webdriver = ChromeDriver()
    @AfterAll
    fun tearDown() {
      webdriver.close()
      webdriver.quit()
    }
  }
}

