package com.rongji.egov.example.service;

import com.rongji.egov.mybatis.base.annotation.Table;
import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.filter.AnnotationTypeFilter;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.Set;

public class ClassPathModelScanner extends ClassPathBeanDefinitionScanner {
    private static final Logger LOGGER = LoggerFactory.getLogger(ClassPathModelScanner.class);

    private final Class<? extends Annotation> annotationClass = Table.class;

    public ClassPathModelScanner(BeanDefinitionRegistry registry) {
        super(registry, false);
        registerFilters();
    }

    private void registerFilters() {
        addIncludeFilter(new AnnotationTypeFilter(this.annotationClass));

        // exclude package-info.java
        addExcludeFilter((metadataReader, metadataReaderFactory) -> {
            String className = metadataReader.getClassMetadata().getClassName();
            return className.endsWith("package-info");
        });
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Set<BeanDefinitionHolder> doScan(String... basePackages) {
        Set<BeanDefinitionHolder> beanDefinitions = super.doScan(basePackages);
        if (beanDefinitions.isEmpty()) {
            LOGGER.warn(() -> "No table model was found in '" + Arrays.toString(basePackages)
                    + "' package. Please check your configuration.");
        }
        return beanDefinitions;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {
        AnnotationMetadata metadata = beanDefinition.getMetadata();
        return metadata.isIndependent() && metadata.isConcrete() && metadata.hasAnnotation(this.annotationClass.getName());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean checkCandidate(String beanName, BeanDefinition beanDefinition) {
        if (super.checkCandidate(beanName, beanDefinition)) {
            return true;
        } else {
            LOGGER.warn(() -> "Skipping ModelFactoryBean with name '" + beanName + "' and '"
                    + beanDefinition.getBeanClassName() + "' Model" + ". Bean already defined with the same name!");
            return false;
        }
    }
}
