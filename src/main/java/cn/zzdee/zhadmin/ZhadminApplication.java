package cn.zzdee.zhadmin;

import cn.zzdee.zhadmin.config.listener.ApplicationEventListener;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;

@SpringBootApplication
@MapperScan("cn.zzdee.zhadmin.dao")  //扫描mapper包
public class ZhadminApplication {

    public static void main(String[] args) {

        SpringApplication app = new SpringApplication(ZhadminApplication.class);

        //添加ServletContext监听器
        app.addListeners(new ApplicationEventListener());

        app.run(args);
    }

    /**
     * 配置fastJson
     *
     * @return
     */
    @Bean
    public HttpMessageConverters fastJsonHttpMessageConverters() {

        //1.需要定义一个Convert转换消息的对象
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();

        //2.添加fastJson的配置信息，比如是否要格式化返回的json数据
        FastJsonConfig fastJsonConfig = new FastJsonConfig();

        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);

        //3.在convert中添加配置信息
        fastConverter.setFastJsonConfig(fastJsonConfig);

        HttpMessageConverter<?> converter = fastConverter;

        return new HttpMessageConverters(converter);
    }


}
