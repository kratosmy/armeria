/*
 * Copyright 2017 LINE Corporation
 *
 * LINE Corporation licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package com.linecorp.armeria.client.retry;

import static com.google.common.base.Preconditions.checkArgument;

import com.google.common.base.MoreObjects;

final class FixedBackoff extends AbstractBackoff {
    static final Backoff NO_DELAY = new FixedBackoff(0);

    private final long intervalMillis;

    FixedBackoff(long intervalMillis) {
        checkArgument(intervalMillis >= 0, "intervalMillis: %s (expected: >= 0)", intervalMillis);
        this.intervalMillis = intervalMillis;
    }

    @Override
    protected long doNextIntervalMillis(int numAttemptsSoFar) {
        return intervalMillis;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                          .add("intervalMillis", intervalMillis)
                          .toString();
    }
}
