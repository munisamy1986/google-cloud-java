/*
 * Copyright 2016 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.gcloud.dns;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.MoreObjects;
import com.google.gcloud.spi.DnsServiceRpc;

import java.io.Serializable;
import java.util.Objects;

/**
 * A base class for options.
 */
public abstract class AbstractOption implements Serializable {

  private static final long serialVersionUID = 201601261704L;
  private final Object value;
  private final DnsServiceRpc.Option rpcOption;

  AbstractOption(DnsServiceRpc.Option rpcOption, Object value) {
    this.rpcOption = checkNotNull(rpcOption);
    this.value = value;
  }

  Object value() {
    return value;
  }

  DnsServiceRpc.Option rpcOption() {
    return rpcOption;
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof AbstractOption)) {
      return false;
    }
    AbstractOption other = (AbstractOption) obj;
    return Objects.equals(value, other.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("value", value)
        .toString();
  }
}
