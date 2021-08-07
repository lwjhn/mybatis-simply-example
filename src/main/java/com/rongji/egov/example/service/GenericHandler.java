package com.rongji.egov.example.service;

import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class GenericHandler<T> {

    public void setGenericT(Class<?> type) {
        System.out.println(type);
    }

    public void setSubGeneric(Class<?> type) {
        System.out.println(type);
    }

    /**
     * T , T<S>
     */
    public void initGeneric() {
        Type pType = getClass().getGenericSuperclass();
        if (pType instanceof ParameterizedType) {
            Type[] tTypes = ((ParameterizedType) pType).getActualTypeArguments();
            if (tTypes != null && tTypes.length > indexT()) {
                Type tType = tTypes[indexT()];
                setGenericT(getClassByType(tType));
                if (tType instanceof ParameterizedType) {
                    Type[] sTypes = ((ParameterizedType) tType).getActualTypeArguments();
                    if (sTypes != null && sTypes.length == 1) {
                        setGenericT(getClassByType(sTypes[0]));
                    }
                }
            }
        }
    }

    public Class<?> getClassByType(Type type) {
        if (type instanceof Class<?>) {
            return (Class<?>) type;
        } else if (type instanceof ParameterizedType) {
            return (Class<?>) ((ParameterizedType) type).getRawType();
        } else if (type instanceof GenericArrayType) {
            Class<?> componentType = (Class<?>) ((GenericArrayType) type).getGenericComponentType();
            return Array.newInstance(componentType, 0).getClass();
        } else {
            return null;
        }
    }

    public int indexT() {
        return 0;
    }


    /*
    if (resolvedReturnType instanceof Class) {
      returnType = (Class<?>) resolvedReturnType;
      if (returnType.isArray()) {
        returnType = returnType.getComponentType();
      }
      // gcode issue #508
      if (void.class.equals(returnType)) {
        ResultType rt = method.getAnnotation(ResultType.class);
        if (rt != null) {
          returnType = rt.value();
        }
      }
    } else if (resolvedReturnType instanceof ParameterizedType) {
      ParameterizedType parameterizedType = (ParameterizedType) resolvedReturnType;
      Class<?> rawType = (Class<?>) parameterizedType.getRawType();
      if (Collection.class.isAssignableFrom(rawType) || Cursor.class.isAssignableFrom(rawType)) {
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        if (actualTypeArguments != null && actualTypeArguments.length == 1) {
          Type returnTypeParameter = actualTypeArguments[0];
          if (returnTypeParameter instanceof Class<?>) {
            returnType = (Class<?>) returnTypeParameter;
          } else if (returnTypeParameter instanceof ParameterizedType) {
            // (gcode issue #443) actual type can be a also a parameterized type
            returnType = (Class<?>) ((ParameterizedType) returnTypeParameter).getRawType();
          } else if (returnTypeParameter instanceof GenericArrayType) {
            Class<?> componentType = (Class<?>) ((GenericArrayType) returnTypeParameter).getGenericComponentType();
            // (gcode issue #525) support List<byte[]>
            returnType = Array.newInstance(componentType, 0).getClass();
          }
        }
      } else if (method.isAnnotationPresent(MapKey.class) && Map.class.isAssignableFrom(rawType)) {
        // (gcode issue 504) Do not look into Maps if there is not MapKey annotation
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        if (actualTypeArguments != null && actualTypeArguments.length == 2) {
          Type returnTypeParameter = actualTypeArguments[1];
          if (returnTypeParameter instanceof Class<?>) {
            returnType = (Class<?>) returnTypeParameter;
          } else if (returnTypeParameter instanceof ParameterizedType) {
            // (gcode issue 443) actual type can be a also a parameterized type
            returnType = (Class<?>) ((ParameterizedType) returnTypeParameter).getRawType();
          }
        }
      } else if (Optional.class.equals(rawType)) {
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        Type returnTypeParameter = actualTypeArguments[0];
        if (returnTypeParameter instanceof Class<?>) {
          returnType = (Class<?>) returnTypeParameter;
        }
      }
    }

     */
}
