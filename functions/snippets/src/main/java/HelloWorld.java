/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

// [START functions_helloworld_http]
// [START functions_helloworld_get]
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWorld {
  // [END functions_helloworld_get]
  // [START functions_helloworld_http]
  // HTTP Cloud Function.
  public void helloGet(HttpServletRequest request, HttpServletResponse response)
      throws IOException {
    String name = request.getParameter("name");
    if (name == null) {
      name = "World";
    }
    PrintWriter writer = response.getWriter();
    writer.write(String.format("Hello %s!", name));
  }
  // [END functions_helloworld_http]
  
  // [START functions_helloworld_get]
  // Simple function to return "Hello World"
  public void helloGet(HttpServletRequest request, HttpServletResponse response)
      throws IOException {
    PrintWriter writer = response.getWriter();
    writer.write("Hello World!");
  }
  // [START functions_helloworld_http]
}

// [END functions_helloworld_get]
// [END functions_helloworld_http]
