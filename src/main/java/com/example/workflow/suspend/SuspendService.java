package com.example.workflow.suspend;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component(value = "suspendService")
public class SuspendService implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {

        execution.getProcessEngineServices()
                .getRuntimeService()
                .updateProcessInstanceSuspensionState()
                .byProcessInstanceId(execution.getProcessInstanceId())
                .suspend();

        System.out.println("Process Suspended: " + execution.getProcessInstanceId());
    }
}
