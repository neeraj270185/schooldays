package enums;

interface State {
	public void process();
}

public enum States implements State {
	RUNNABLE {
		public void process() {
			System.out.println("runnable");
		}
	},
	RUNNING {

		@Override
		public void process() {
			System.out.println("RUNNING");
		}

	},
	FINISHED {
		@Override
		public void process() {
			System.out.println("FINISHED");
		}
	};

}
