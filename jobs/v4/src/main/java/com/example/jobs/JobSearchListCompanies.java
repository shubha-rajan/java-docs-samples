/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.jobs;

// [START job_search_list_companies_beta]

import com.google.cloud.talent.v4beta1.Company;
import com.google.cloud.talent.v4beta1.CompanyServiceClient;
import com.google.cloud.talent.v4beta1.ListCompaniesRequest;
import com.google.cloud.talent.v4beta1.TenantName;
import com.google.cloud.talent.v4beta1.TenantOrProjectName;

import java.io.IOException;

public class JobSearchListCompanies {

  public static void listCompanies() throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "your-project-id";
    String tenantId = "your-tenant-id";
    listCompanies(projectId, tenantId);
  }

  // List Companies.
  public static void listCompanies(String projectId, String tenantId) throws IOException {
    try (CompanyServiceClient companyServiceClient = CompanyServiceClient.create()) {
      TenantOrProjectName parent = TenantName.of(projectId, tenantId);

      ListCompaniesRequest request =
          ListCompaniesRequest.newBuilder().setParent(parent.toString()).build();

      for (Company responseItem : companyServiceClient.listCompanies(request).iterateAll()) {
        System.out.printf("Company Name: %s\n", responseItem.getName());
        System.out.printf("Display Name: %s\n", responseItem.getDisplayName());
        System.out.printf("External ID: %s\n", responseItem.getExternalId());
      }
    }
  }
}
// [END job_search_list_companies_beta]
