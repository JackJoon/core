package sp.core.web;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;
import sp.core.commmon.MyLogger;

@Service
@RequiredArgsConstructor
public class LogDemoService {

    private final ObjectProvider<MyLogger> logger;

    public void logic(String id) {

        logger.log("service id = " +id);
    }
}
