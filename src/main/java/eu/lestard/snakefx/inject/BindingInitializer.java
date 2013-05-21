package eu.lestard.snakefx.inject;

import javafx.beans.binding.Bindings;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import eu.lestard.snakefx.viewmodel.ViewModel;


/**
 * This class initializes some of the bindings between the ui and the
 * application.
 * 
 * @author manuel.mauky
 * 
 */
public class BindingInitializer {
	private static final String FXML_ID_POINTS_LABEL = "#pointsLabel";

	private static final String FXML_ID_PLAY_PAUSE_BUTTON = "#playPauseButton";


	private final Parent mainRoot;

	private final CoreInjector coreInjector;

	private final ControllerInjector controllerInjector;

	private final ViewModel viewModel;

	public BindingInitializer(final Parent mainRoot, final CoreInjector coreInjector,
			final ControllerInjector controllerInjector, final ViewModel viewModel) {
		this.mainRoot = mainRoot;
		this.coreInjector = coreInjector;
		this.controllerInjector = controllerInjector;
		this.viewModel = viewModel;
	}

	/**
	 * Initialize all Bindings.
	 */
	public void initBindings() {
		initPointsBinding();
		initPlayPauseControllerBindings();
	}

	private void initPointsBinding() {
		final Label pointsLabel = (Label) mainRoot.lookup(FXML_ID_POINTS_LABEL);
		pointsLabel.textProperty().bind(Bindings.convert(viewModel.pointsProperty()));
	}

	private void initPlayPauseControllerBindings() {
		// final Button playPauseButton = (Button)
		// mainRoot.lookup(FXML_ID_PLAY_PAUSE_BUTTON);
		//
		// final PlayPauseController playPauseController =
		// controllerInjector.getPlayPauseController();
		//
		// playPauseButton.setOnAction(new EventHandler<ActionEvent>() {
		// @Override
		// public void handle(final ActionEvent arg0) {
		// playPauseController.togglePlayPause();
		// }
		// });
		//
		// playPauseController.buttonLabelProperty().bindBidirectional(playPauseButton.textProperty());
		// playPauseController.disabledProperty().bindBidirectional(playPauseButton.disableProperty());
	}
}
