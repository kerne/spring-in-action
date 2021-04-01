package cl.caraya.action.beans.requeridconstructor;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
public class RequiredConstructorImpl implements RequiredConstructorBean {

    private final RequiredBeanService requiredBeanService;


    @Override
    public void required() {
        requiredBeanService.required();
    }
}
