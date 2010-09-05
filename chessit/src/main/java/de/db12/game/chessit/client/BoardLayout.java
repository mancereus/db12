package de.db12.game.chessit.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;

import de.db12.game.chessit.client.BoardPresenter.MyView;

public class BoardLayout extends ViewImpl implements MyView {
    interface MyUiBinder extends UiBinder<DockLayoutPanel, BoardLayout> {
    }

    private static MyUiBinder uiBinder = GWT.create(MyUiBinder.class);
    private static BoardResources res = GWT.create(BoardResources.class);

    @UiField
    HasWidgets help;
    @UiField
    HasWidgets whand;
    @UiField
    HasWidgets wdrop;
    @UiField
    HasWidgets bhand;
    @UiField
    HasWidgets bdrop;
    @UiField
    AbsolutePanel table;
    @UiField
    DockLayoutPanel sidepanel;

    private final DockLayoutPanel panel;

    @Inject
    public BoardLayout() {
        panel = uiBinder.createAndBindUi(this);
        panel.setHeight("800px");
    }

    public void setHelp(String name) {
        help.add(new Label(name));
    }

    @Override
    public HasWidgets getBlackDrop() {
        return bdrop;
    }

    @Override
    public HasWidgets getBlackHand() {
        return bhand;
    }

    @Override
    public AbsolutePanel getTable() {
        return table;
    }

    @Override
    public AbsolutePanel getBoard() {
        return table;
    }

    @Override
    public HasWidgets getHelp() {
        return help;
    }

    @Override
    public HasWidgets getWhiteDrop() {
        return wdrop;
    }

    @Override
    public HasWidgets getWhiteHand() {
        return whand;
    }

    @Override
    public Widget asWidget() {
        return panel;
    }

    // @Override
    // public HandlerRegistration
    // addValueChangeHandler(ValueChangeHandler<List<String>> handler) {
    // return null;
    // }
    //
    // @Override
    // public List<String> getValue() {
    // return null;
    // }
    //
    // @Override
    // public void setValue(List<String> value) {
    // }
    //
    // @Override
    // public void setValue(List<String> value, boolean fireEvents) {
    // }

}