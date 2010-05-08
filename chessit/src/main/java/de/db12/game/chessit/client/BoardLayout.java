package de.db12.game.chessit.client;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Label;

import de.db12.game.chessit.client.BoardPresenter.Display;

public class BoardLayout extends Composite implements Display {
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
    private final int size;

    private final HandlerManager eventbus;

    public BoardLayout(int pxsize, HandlerManager eventbus) {
        this.size = pxsize;
        this.eventbus = eventbus;
        initWidget(uiBinder.createAndBindUi(this));
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
    public HandlerRegistration addValueChangeHandler(ValueChangeHandler<List<String>> handler) {
        return null;
    }

    @Override
    public List<String> getValue() {
        return null;
    }

    @Override
    public void setValue(List<String> value) {
    }

    @Override
    public void setValue(List<String> value, boolean fireEvents) {
    }

}