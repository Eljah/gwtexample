package shop.itis.kpfu.ru.client;


import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.*;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;
import shop.itis.kpfu.ru.client.service.GoodService;
import shop.itis.kpfu.ru.client.service.GoodServiceAsync;
import shop.itis.kpfu.ru.shared.model.Good;


/*
public class HelloGWT implements EntryPoint {

    @Override
    public void onModuleLoad() {
        Label greetingLabel = new Label("Hello, GWT!");
        RootPanel.get().add(greetingLabel);
    }
}
*/


public class HelloGWT implements EntryPoint {
    private GreetingServiceAsync greetingService = GWT.create(GreetingService.class);
    private GoodServiceAsync goodServiceAsyncService = GWT.create(GoodService.class);

    private TextBox nameTextBox = new TextBox();
    private Label greetingLabel = new Label("Good just added!");

    @Override
    public void onModuleLoad() {
        RootPanel.get().add(nameTextBox);
        RootPanel.get().add(greetingLabel);

        final AsyncCallback<String> callback = new AsyncCallback<String>() {
            @Override
            public void onFailure(Throwable caught) {
                greetingLabel.setText("ERROR!");
            }

            @Override
            public void onSuccess(String result) {
                greetingLabel.setText(result);
            }
        };

        nameTextBox.addKeyDownHandler(new KeyDownHandler() {
            @Override
            public void onKeyDown(KeyDownEvent event) {
                if(event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
                    Good g=new Good();
                    g.setName(nameTextBox.getText());
                    goodServiceAsyncService.addGood(g,callback);
                }
            }
        });

    }
}
