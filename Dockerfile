FROM amazoncorretto:21-al2-jdk

# ENV JAVA_XMS             <set initial Java heap size>
# ENV JAVA_XMX             <set maximum Java heap size>
# ENV PORT                 <port to run server>
# ENV MONITORING_URL
# ENV REDIS_HOST           <redis server host name>
# ENV REDIS_PORT           <redis server port>
# ENV TRACING_URL
# ENV USERS_SERVICE_BASEURI
# ENV PRODUCTS_SERVICE_BASEURI
# ENV ORDERS_SERVICE_BASEURI

ADD target/*.jar /opt/admin-bff.jar

RUN bash -c 'touch /opt/orders-service.jar'

RUN echo "#!"

RUN echo "#!/usr/bin/env bash" > /opt/entrypoint.sh && \
    echo "" >> /opt/entrypoint.sh && \
    echo "echo \"===============================================\" " >> /opt/entrypoint.sh && \
    echo "echo \"JAVA_XMS: \$JAVA_XMS \" " >> /opt/entrypoint.sh && \
    echo "echo \"JAVA_XMX: \$JAVA_XMX \" " >> /opt/entrypoint.sh && \
    echo "echo \"===============================================\" " >> /opt/entrypoint.sh && \
    echo "echo \"PORT: \$PORT \" " >> /opt/entrypoint.sh && \
    echo "echo \"MONITORING_URL: \$MONITORING_URL\" " >> /opt/entrypoint.sh && \
    echo "echo \"REDIS_HOST: \$REDIS_HOST \" " >> /opt/entrypoint.sh && \
    echo "echo \"REDIS_PORT: \$REDIS_PORT \" " >> /opt/entrypoint.sh && \
    echo "echo \"TRACING_URL: \$TRACING_URL \" " >> /opt/entrypoint.sh && \
    echo "echo \"USERS_SERVICE_BASEURI: \$USERS_SERVICE_BASEURI \" " >> /opt/entrypoint.sh && \
    echo "echo \"PRODUCTS_SERVICE_BASEURI: \$PRODUCTS_SERVICE_BASEURI \" " >> /opt/entrypoint.sh && \
    echo "echo \"ORDERS_SERVICE_BASEURI: \$ORDERS_SERVICE_BASEURI \" " >> /opt/entrypoint.sh && \
    echo "echo \"===============================================\" " >> /opt/entrypoint.sh && \
    echo "" >> /opt/entrypoint.sh && \
    echo "java -XX:+UseG1GC -XX:MaxGCPauseMillis=200 -Xms\$JAVA_XMS -Xmx\$JAVA_XMX \
        -Dserver.port=\$PORT \
        -Dmanagement.server.port=\$PORT \
        -Dspring.boot.admin.client.url=\$MONITORING_URL \
        -Dspring.data.redis.host=\$REDIS_HOST \
        -Dspring.data.redis.port=\$REDIS_PORT \
        -Decomm.bff.tracing.url=\$TRACING_URL \
        -Decomm.bff.users.baseUri=\$USERS_SERVICE_BASEURI \
        -Decomm.bff.products.baseUri=\$PRODUCTS_SERVICE_BASEURI \
        -Decomm.bff.orders.baseUri=\$ORDERS_SERVICE_BASEURI \
        -jar /opt/admin-bff.jar" >> /opt/entrypoint.sh

RUN chmod 755 /opt/entrypoint.sh

WORKDIR /app

EXPOSE ${PORT}

ENTRYPOINT [ "/opt/entrypoint.sh" ]
