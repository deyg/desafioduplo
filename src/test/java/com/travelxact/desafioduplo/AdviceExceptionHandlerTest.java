package com.travelxact.desafioduplo;


import com.travelxact.desafioduplo.exception.exceptionhandler.AdviceExceptionHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.beans.PropertyEditor;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AdviceExceptionHandlerTest {

    private AdviceExceptionHandler adviceExceptionHandler;

    @BeforeEach
    void setUp() {
        adviceExceptionHandler = new AdviceExceptionHandler();
    }

    @Test
    void testHandleMethodArgumentNotValid() {
        MethodArgumentNotValidException exception = methodArgumentNotValidExceptionMock();

        ResponseEntity<Object> responseEntity = adviceExceptionHandler.handleMethodArgumentNotValid(exception,
                null, HttpStatus.BAD_REQUEST, null);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        Map<String, Object> responseBody = (Map<String, Object>) responseEntity.getBody();
        List<String> errors = (List<String>) responseBody.get("errors");
        assertEquals(2, errors.size());
        assertEquals("Field error 1", errors.get(0));
        assertEquals("Field error 2", errors.get(1));
    }

    private MethodArgumentNotValidException methodArgumentNotValidExceptionMock() {
        BindingResult bindingResult = bindingResultMock();
        return new MethodArgumentNotValidException(null, bindingResult);
    }

    private BindingResult bindingResultMock() {
        FieldError fieldError1 = new FieldError("objectName", "field1", "Field error 1");
        FieldError fieldError2 = new FieldError("objectName", "field2", "Field error 2");
        List<FieldError> fieldErrors = Arrays.asList(fieldError1, fieldError2);

        return new TestBindingResult(fieldErrors);
    }
}

//TODO: Ajustar esta classe
class TestBindingResult implements BindingResult {
    private List<FieldError> fieldErrors;

    TestBindingResult(List<FieldError> fieldErrors) {
        this.fieldErrors = fieldErrors;
    }

    @Override
    public String getObjectName() {
        return null;
    }

    @Override
    public void setNestedPath(String s) {

    }

    @Override
    public String getNestedPath() {
        return null;
    }

    @Override
    public void pushNestedPath(String s) {

    }

    @Override
    public void popNestedPath() throws IllegalStateException {

    }

    @Override
    public void reject(String s) {

    }

    @Override
    public void reject(String s, String s1) {

    }

    @Override
    public void reject(String s, Object[] objects, String s1) {

    }

    @Override
    public void rejectValue(String s, String s1) {

    }

    @Override
    public void rejectValue(String s, String s1, String s2) {

    }

    @Override
    public void rejectValue(String s, String s1, Object[] objects, String s2) {

    }

    @Override
    public void addAllErrors(Errors errors) {

    }

    @Override
    public boolean hasErrors() {
        return false;
    }

    @Override
    public int getErrorCount() {
        return 0;
    }

    @Override
    public List<ObjectError> getAllErrors() {
        return null;
    }

    @Override
    public boolean hasGlobalErrors() {
        return false;
    }

    @Override
    public int getGlobalErrorCount() {
        return 0;
    }

    @Override
    public List<ObjectError> getGlobalErrors() {
        return null;
    }

    @Override
    public ObjectError getGlobalError() {
        return null;
    }

    @Override
    public boolean hasFieldErrors() {
        return false;
    }

    @Override
    public int getFieldErrorCount() {
        return 0;
    }

    @Override
    public List<FieldError> getFieldErrors() {
        return fieldErrors;
    }

    @Override
    public FieldError getFieldError() {
        return null;
    }

    @Override
    public boolean hasFieldErrors(String s) {
        return false;
    }

    @Override
    public int getFieldErrorCount(String s) {
        return 0;
    }

    @Override
    public List<FieldError> getFieldErrors(String s) {
        return null;
    }

    @Override
    public FieldError getFieldError(String s) {
        return null;
    }

    @Override
    public Object getFieldValue(String s) {
        return null;
    }

    @Override
    public Class<?> getFieldType(String s) {
        return null;
    }

    @Override
    public Object getTarget() {
        return null;
    }

    @Override
    public Map<String, Object> getModel() {
        return null;
    }

    @Override
    public Object getRawFieldValue(String s) {
        return null;
    }

    @Override
    public PropertyEditor findEditor(String s, Class<?> aClass) {
        return null;
    }

    @Override
    public PropertyEditorRegistry getPropertyEditorRegistry() {
        return null;
    }

    @Override
    public String[] resolveMessageCodes(String s) {
        return new String[0];
    }

    @Override
    public String[] resolveMessageCodes(String s, String s1) {
        return new String[0];
    }

    @Override
    public void addError(ObjectError objectError) {

    }

    // Implement other methods from the BindingResult interface if necessary
}