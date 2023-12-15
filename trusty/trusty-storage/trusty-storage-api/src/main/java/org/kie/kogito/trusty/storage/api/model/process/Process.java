/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.kie.kogito.trusty.storage.api.model.process;

import java.util.Collection;
import java.util.List;

import org.kie.kogito.ModelDomain;
import org.kie.kogito.trusty.storage.api.model.Execution;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotNull;

/**
 * A <b>Process</b> <code>Execution</code>
 */
public final class Process extends Execution {

    public static final String INPUTS_FIELD = "inputs";
    public static final String OUTCOMES_FIELD = "outcomes";

    @JsonProperty(EXECUTED_MODEL_NAMESPACE_FIELD)
    private String executedModelNamespace;

    @JsonProperty(INPUTS_FIELD)
    private Collection<ProcessInput> inputs;

    @JsonProperty(OUTCOMES_FIELD)
    private Collection<ProcessOutcome> outcomes;

    public Process() {
        super(ModelDomain.PROCESS);
    }

    public Process(@NotNull String executionId,
            String sourceUrl,
            String serviceUrl,
            Long executionTimestamp,
            Boolean hasSucceeded,
            String executorName,
            String executedModelName,
            String executedModelNamespace,
            List<ProcessInput> inputs,
            List<ProcessOutcome> outcomes) {
        super(executionId, sourceUrl, serviceUrl, executionTimestamp, hasSucceeded, executorName,
                executedModelName, ModelDomain.PROCESS);
        this.executedModelNamespace = executedModelNamespace;
        this.inputs = inputs;
        this.outcomes = outcomes;
    }

    /**
     * Gets the namespace of the executed model.
     * 
     * @return The namespace of the executed model.
     */
    public String getExecutedModelNamespace() {
        return executedModelNamespace;
    }

    /**
     * Sets the executed model namespace.
     * 
     * @param executedModelNamespace The executed model namespace.
     */
    public void setExecutedModelNamespace(String executedModelNamespace) {
        this.executedModelNamespace = executedModelNamespace;
    }

    public Collection<ProcessInput> getInputs() {
        return inputs;
    }

    public void setInputs(Collection<ProcessInput> inputs) {
        this.inputs = inputs;
    }

    public Collection<ProcessOutcome> getOutcomes() {
        return outcomes;
    }

    public void setOutcomes(Collection<ProcessOutcome> outcomes) {
        this.outcomes = outcomes;
    }
}
