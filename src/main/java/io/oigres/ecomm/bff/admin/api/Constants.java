/**********
 This project is free software; you can redistribute it and/or modify it under
 the terms of the GNU General Public License as published by the
 Free Software Foundation; either version 3.0 of the License, or (at your
 option) any later version. (See <https://www.gnu.org/licenses/gpl-3.0.html>.)

 This project is distributed in the hope that it will be useful, but WITHOUT
 ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 FOR A PARTICULAR PURPOSE.  See the GNU General Public License for
 more details.

 You should have received a copy of the GNU General Public License
 along with this project; if not, write to the Free Software Foundation, Inc.,
 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301  USA
 **********/
// Copyright (c) 2024-2025 Sergio Exposito.  All rights reserved.              

package io.oigres.ecomm.bff.admin.api;

public class Constants {
  public static final String HTTP_HEADER_DISTRIBUTED_TRACE_ID = "X-Ecomm-Trace-Id";
  public static final String HTTP_HEADER_NEW_JWT_TOKEN = "X-Ecomm-New-JWT-Token";
  public static final String HTTP_HEADER_SIGN_IN_EMAIL = "X-Ecomm-SignIn-Email";
  public static final String HTTP_HEADER_SIGN_IN_PASSWORD = "X-Ecomm-SignIn-Password";
  public static final String DEFAULT_PAGE = "0";
  public static final String DEFAULT_PAGE_SIZE = "20";
  public static final String QUERY_PARAM_PAGE = "page";
  public static final String QUERY_PARAM_SIZE = "size";
  //    public static final String EMAIL_REGEX_VALIDATION = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
  public static final String EMAIL_REGEX_VALIDATION =
      "(?:(?:\\r"
          + "\\n"
          + ")?[ \\t])*(?:(?:(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r"
          + "\\n"
          + ")?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r"
          + "\\\\]|\\\\.|(?:(?:\\r"
          + "\\n"
          + ")?[ \\t]))*\"(?:(?:\\r"
          + "\\n"
          + ")?[ \\t])*)(?:\\.(?:(?:\\r"
          + "\\n"
          + ")?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r"
          + "\\n"
          + ")?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r"
          + "\\\\]|\\\\.|(?:(?:\\r"
          + "\\n"
          + ")?[ \\t]))*\"(?:(?:\\r"
          + "\\n"
          + ")?[ \\t])*))*@(?:(?:\\r"
          + "\\n"
          + ")?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r"
          + "\\n"
          + ")?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r"
          + "\\\\]|\\\\.)*\\](?:(?:\\r"
          + "\\n"
          + ")?[ \\t])*)(?:\\.(?:(?:\\r"
          + "\\n"
          + ")?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r"
          + "\\n"
          + ")?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r"
          + "\\\\]|\\\\.)*\\](?:(?:\\r"
          + "\\n"
          + ")?[ \\t])*))*|(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r"
          + "\\n"
          + ")?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r"
          + "\\n"
          + ")?[ \\t]))*\"(?:(?:\\r"
          + "\\n"
          + ")?[ \\t])*)*\\<(?:(?:\\r"
          + "\\n"
          + ")?[ \\t])*(?:@(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r"
          + "\\n"
          + ")?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r"
          + "\\\\]|\\\\.)*\\](?:(?:\\r"
          + "\\n"
          + ")?[ \\t])*)(?:\\.(?:(?:\\r"
          + "\\n"
          + ")?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r"
          + "\\n"
          + ")?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r"
          + "\\\\]|\\\\.)*\\](?:(?:\\r"
          + "\\n"
          + ")?[ \\t])*))*(?:,@(?:(?:\\r"
          + "\\n"
          + ")?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r"
          + "\\n"
          + ")?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r"
          + "\\\\]|\\\\.)*\\](?:(?:\\r"
          + "\\n"
          + ")?[ \\t])*)(?:\\.(?:(?:\\r"
          + "\\n"
          + ")?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r"
          + "\\n"
          + ")?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r"
          + "\\\\]|\\\\.)*\\](?:(?:\\r"
          + "\\n"
          + ")?[ \\t])*))*)*:(?:(?:\\r"
          + "\\n"
          + ")?[ \\t])*)?(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r"
          + "\\n"
          + ")?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r"
          + "\\\\]|\\\\.|(?:(?:\\r"
          + "\\n"
          + ")?[ \\t]))*\"(?:(?:\\r\\n"
          + ")?[ \\t])*)(?:\\.(?:(?:\\r"
          + "\\n"
          + ")?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r"
          + "\\n"
          + ")?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r"
          + "\\\\]|\\\\.|(?:(?:\\r"
          + "\\n"
          + ")?[ \\t]))*\"(?:(?:\\r"
          + "\\n"
          + ")?[ \\t])*))*@(?:(?:\\r"
          + "\\n"
          + ")?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r"
          + "\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r"
          + "\\\\]|\\\\.)*\\](?:(?:\\r"
          + "\\n"
          + ")?[ \\t])*)(?:\\.(?:(?:\\r"
          + "\\n"
          + ")?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r"
          + "\\n"
          + ")?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r"
          + "\\\\]|\\\\.)*\\](?:(?:\\r"
          + "\\n"
          + ")?[ \\t])*))*\\>(?:(?:\\r"
          + "\\n"
          + ")?[ \\t])*)|(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r"
          + "\\n"
          + ")?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r"
          + "\\\\]|\\\\.|(?:(?:\\r"
          + "\\n"
          + ")?[ \\t]))*\"(?:(?:\\r"
          + "\\n"
          + ")?[ \\t])*)*:(?:(?:\\r"
          + "\\n"
          + ")?[ \\t])*(?:(?:(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r"
          + "\\n"
          + ")?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r"
          + "\\\\]|\\\\.|(?:(?:\\r"
          + "\\n"
          + ")?[ \\t]))*\"(?:(?:\\r"
          + "\\n"
          + ")?[ \\t])*)(?:\\.(?:(?:\\r"
          + "\\n"
          + ")?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r"
          + "\\n"
          + ")?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r"
          + "\\\\]|\\\\.|(?:(?:\\r"
          + "\\n"
          + ")?[ \\t]))*\"(?:(?:\\r"
          + "\\n"
          + ")?[ \\t])*))*@(?:(?:\\r"
          + "\\n"
          + ")?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r"
          + "\\n"
          + ")?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r"
          + "\\\\]|\\\\.)*\\](?:(?:\\r"
          + "\\n"
          + ")?[ \\t])*)(?:\\.(?:(?:\\r"
          + "\\n"
          + ")?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r"
          + "\\n"
          + ")?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r"
          + "\\\\]|\\\\.)*\\](?:(?:\\r"
          + "\\n"
          + ")?[ \\t])*))*|(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r"
          + "\\n"
          + ")?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r"
          + "\\\\]|\\\\.|(?:(?:\\r"
          + "\\n"
          + ")?[ \\t]))*\"(?:(?:\\r"
          + "\\n"
          + ")?[ \\t])*)*\\<(?:(?:\\r"
          + "\\n"
          + ")?[ \\t])*(?:@(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r"
          + "\\n"
          + ")?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r"
          + "\\\\]|\\\\.)*\\](?:(?:\\r"
          + "\\n"
          + ")?[ \\t])*)(?:\\.(?:(?:\\r"
          + "\\n"
          + ")?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r"
          + "\\n"
          + ")?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r"
          + "\\\\]|\\\\.)*\\](?:(?:\\r"
          + "\\n"
          + ")?[ \\t])*))*(?:,@(?:(?:\\r"
          + "\\n"
          + ")?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r"
          + "\\n"
          + ")?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r"
          + "\\\\]|\\\\.)*\\](?:(?:\\r"
          + "\\n"
          + ")?[ \\t])*)(?:\\.(?:(?:\\r"
          + "\\n"
          + ")?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r"
          + "\\n"
          + ")?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r"
          + "\\\\]|\\\\.)*\\](?:(?:\\r"
          + "\\n"
          + ")?[ \\t])*))*)*:(?:(?:\\r"
          + "\\n"
          + ")?[ \\t])*)?(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r"
          + "\\n"
          + ")?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r"
          + "\\\\]|\\\\.|(?:(?:\\r"
          + "\\n"
          + ")?[ \\t]))*\"(?:(?:\\r"
          + "\\n"
          + ")?[ \\t])*)(?:\\.(?:(?:\\r"
          + "\\n"
          + ")?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r"
          + "\\n"
          + ")?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r"
          + "\\\\]|\\\\.|(?:(?:\\r"
          + "\\n"
          + ")?[ \\t]))*\"(?:(?:\\r"
          + "\\n"
          + ")?[ \\t])*))*@(?:(?:\\r"
          + "\\n"
          + ")?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r"
          + "\\n"
          + ")?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r"
          + "\\\\]|\\\\.)*\\](?:(?:\\r"
          + "\\n"
          + ")?[ \\t])*)(?:\\.(?:(?:\\r"
          + "\\n"
          + ")?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r"
          + "\\n"
          + ")?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r"
          + "\\\\]|\\\\.)*\\](?:(?:\\r"
          + "\\n"
          + ")?[ \\t])*))*\\>(?:(?:\\r"
          + "\\n"
          + ")?[ \\t])*)(?:,\\s*(?:(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r"
          + "\\n"
          + ")?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r"
          + "\\\\]|\\\\.|(?:(?:\\r"
          + "\\n"
          + ")?[ \\t]))*\"(?:(?:\\r"
          + "\\n"
          + ")?[ \\t])*)(?:\\.(?:(?:\\r"
          + "\\n"
          + ")?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r"
          + "\\n"
          + ")?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r"
          + "\\\\]|\\\\.|(?:(?:\\r"
          + "\\n"
          + ")?[ \\t]))*\"(?:(?:\\r"
          + "\\n"
          + ")?[ \\t])*))*@(?:(?:\\r"
          + "\\n"
          + ")?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r"
          + "\\n"
          + ")?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r"
          + "\\\\]|\\\\.)*\\](?:(?:\\r"
          + "\\n"
          + ")?[ \\t])*)(?:\\.(?:(?:\\r"
          + "\\n"
          + ")?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r"
          + "\\n"
          + ")?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r"
          + "\\\\]|\\\\.)*\\](?:(?:\\r"
          + "\\n"
          + ")?[ \\t])*))*|(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r"
          + "\\n"
          + ")?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r"
          + "\\\\]|\\\\.|(?:(?:\\r"
          + "\\n"
          + ")?[ \\t]))*\"(?:(?:\\r"
          + "\\n"
          + ")?[ \\t])*)*\\<(?:(?:\\r"
          + "\\n"
          + ")?[ \\t])*(?:@(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r"
          + "\\n"
          + ")?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r"
          + "\\\\]|\\\\.)*\\](?:(?:\\r"
          + "\\n"
          + ")?[ \\t])*)(?:\\.(?:(?:\\r"
          + "\\n"
          + ")?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r"
          + "\\n"
          + ")?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r"
          + "\\\\]|\\\\.)*\\](?:(?:\\r"
          + "\\n"
          + ")?[ \\t])*))*(?:,@(?:(?:\\r"
          + "\\n"
          + ")?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r"
          + "\\n"
          + ")?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r"
          + "\\\\]|\\\\.)*\\](?:(?:\\r"
          + "\\n"
          + ")?[ \\t])*)(?:\\.(?:(?:\\r"
          + "\\n"
          + ")?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r"
          + "\\n"
          + ")?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r"
          + "\\\\]|\\\\.)*\\](?:(?:\\r"
          + "\\n"
          + ")?[ \\t])*))*)*:(?:(?:\\r"
          + "\\n"
          + ")?[ \\t])*)?(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r"
          + "\\n"
          + ")?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r"
          + "\\\\]|\\\\.|(?:(?:\\r"
          + "\\n"
          + ")?[ \\t]))*\"(?:(?:\\r"
          + "\\n"
          + ")?[ \\t])*)(?:\\.(?:(?:\\r"
          + "\\n"
          + ")?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r"
          + "\\n"
          + ")?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r"
          + "\\\\]|\\\\.|(?:(?:\\r"
          + "\\n"
          + ")?[ \\t]))*\"(?:(?:\\r"
          + "\\n"
          + ")?[ \\t])*))*@(?:(?:\\r"
          + "\\n"
          + ")?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r"
          + "\\n"
          + ")?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r"
          + "\\\\]|\\\\.)*\\](?:(?:\\r"
          + "\\n"
          + ")?[ \\t])*)(?:\\.(?:(?:\\r"
          + "\\n"
          + ")?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r"
          + "\\n"
          + ")?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r"
          + "\\\\]|\\\\.)*\\](?:(?:\\r"
          + "\\n"
          + ")?[ \\t])*))*\\>(?:(?:\\r"
          + "\\n"
          + ")?[ \\t])*))*)?;\\s*)";

  private Constants() {}
}
