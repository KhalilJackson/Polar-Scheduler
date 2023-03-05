package edu.bowdoin.csci.PolarScheduler.ui;


import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;

import edu.bowdoin.csci.PolarScheduler.course.Course;
import edu.bowdoin.csci.PolarScheduler.scheduler.PolarScheduler;


/**
 * GUI for the PolarScheduler project.  
 * The GUI displays the course catalog and the student's schedule.
 * 
 * @author Sarah Heckman
 * @author Kai Presler-Marshall
 */
public class PolarSchedulerUI extends JFrame  {
	
	/** ID used for object serialization */
	private static final long serialVersionUID = 1L;
	/** Panel that will contain different views for the application. */
	private JPanel panel;
	/** PolarSchedulerUI title */
	private static final String APP_TITLE = "PolarScheduler";
	/** Constant to identify SchedulerPanel for {@link CardLayout}. */
	private static final String SCHEDULER_PANEL = "SchedulerPanel";
	/** Constant to identify SchedulePanel for {@link CardLayout}. */
	private static final String SCHEDULE_PANEL = "SchedulePanel";
	/** Constant to identify AddCoursePanel for {@link CardLayout}. */
	private static final String ADD_COURSE_PANEL = "AddCoursePanel";
	/** Scheduler panel */
	private SchedulerPanel pnlScheduler;
	/** Schedule panel */
	private SchedulePanel pnlSchedule;
	/** Add Course panel */
	private AddCoursePanel pnlAddCourse;
	/** Reference to {@link CardLayout} for panel.  Stacks all of the panels. */
	private CardLayout cardLayout;
	/** Reference to the WolfScheduler */
	private PolarScheduler scheduler;

	/**
	 * Constructs the WolfSchedulerGUI and sets up the GUI 
	 * components.
	 */
	public PolarSchedulerUI() {
		super();
		
		//Set general GUI info
		setSize(900, 800);
		setLocation(50, 50);
		setTitle(APP_TITLE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//Construct the underlying model object
		try {
			scheduler = new PolarScheduler();
		} catch (IllegalStateException e) {
			System.exit(1);
		}
		
		//Construct panels
		pnlScheduler = new SchedulerPanel();
		pnlSchedule = new SchedulePanel();
		pnlAddCourse = new AddCoursePanel();
		
		//Create JPanel that will hold the rest of the GUI information.
		//The JPanel utilizes a CardLayout, which stacks several different
		//JPanels.  User actions lead to switching which "Card" is visible.
		panel = new JPanel();
		cardLayout = new CardLayout();
		panel.setLayout(cardLayout);
		panel.add(pnlScheduler, SCHEDULER_PANEL);
		panel.add(pnlSchedule, SCHEDULE_PANEL);
		panel.add(pnlAddCourse, ADD_COURSE_PANEL);
		cardLayout.show(panel, SCHEDULER_PANEL);
		
		//Add panel to the container
		Container c = getContentPane();
		c.add(panel, BorderLayout.CENTER);
		
		//Set the GUI visible
		setVisible(true);
	}
	

	/**
	 * Starts the Wolf Scheduler program.
	 * @param args command line arguments
	 */
	public static void main(String [] args) {
		new PolarSchedulerUI();
	}
	
	/**
	 * Inner class that creates the look and behavior for the {@link JPanel} that 
	 * shows the list of requirements.
	 * 
	 * @author Sarah Heckman 
	 */
	private class SchedulerPanel extends JPanel implements ActionListener {
		/** ID number used for object serialization. */
		private static final long serialVersionUID = 1L;
		/** Button for adding the selected course in the catalog to the schedule */
		private JButton btnAddCourse;
		
		/** Button for adding a new course to the catalogue */
		private JButton btnNewCourse;
		
		/** Button for removing the selected Course from the schedule */
		private JButton btnRemoveCourse;
		/** Button for resetting the schedule */
		private JButton btnReset;
		/** Button for displaying the final schedule */
		private JButton btnDisplay;
		/** JTable for displaying the catalog of Courses */
		private JTable tableCatalog;
		/** JTable for displaying the schdule of Courses */
		private JTable tableSchedule;
		/** TableModel for catalog */
		private CourseTableModel catalogTableModel;
		/** TableModel for schedule */
		private CourseTableModel scheduleTableModel;
		/** Student's Schedule title label */
		private JLabel lblScheduleTitle;
		/** Student's Schedule text field */
		private JTextField txtScheduleTitle;
		/** Button for setting student's schedule title */
		private JButton btnSetScheduleTitle;
		/** Border for Schedule */
		private TitledBorder borderSchedule;
		/** Panel for displaying Course Details */
		private JPanel pnlCourseDetails;
		/** Label for Course Details name title */
		private JLabel lblNameTitle = new JLabel("Name: ");
		/** Label for Course Details section title */
		private JLabel lblSectionTitle = new JLabel("Section: ");
		/** Label for Course Details title title */
		private JLabel lblTitleTitle = new JLabel("Title: ");
		/** Label for Course Details instructor title */
		private JLabel lblInstructorTitle = new JLabel("Instructor: ");
		/** Label for Course Details meeting title */
		private JLabel lblMeetingTitle = new JLabel("Meeting: ");
		/** Label for Course Details name */
		private JLabel lblName = new JLabel("");
		/** Label for Course Details section */
		private JLabel lblSection = new JLabel("");
		/** Label for Course Details title */
		private JLabel lblTitle = new JLabel("");
		/** Label for Course Details instructor */
		private JLabel lblInstructor = new JLabel("");
		/** Label for Course Details meeting */
		private JLabel lblMeeting = new JLabel("");
		
		/**
		 * Creates the requirements list.
		 */
		public SchedulerPanel() {
			super(new GridLayout(4, 1));
			
			//Set up the JPanel that will hold action buttons		
			btnAddCourse = new JButton("Add Course");
			btnAddCourse.addActionListener(this);
			btnNewCourse = new JButton("Add New Course");
			btnNewCourse.addActionListener(this);
			
			btnRemoveCourse = new JButton("Remove Course");
			btnRemoveCourse.addActionListener(this);
			btnReset = new JButton("Reset Schedule");
			btnReset.addActionListener(this);
			btnDisplay = new JButton("Display Final Schedule");
			btnDisplay.addActionListener(this);
			lblScheduleTitle = new JLabel("Schedule Title: ");
			txtScheduleTitle = new JTextField(scheduler.getScheduleTitle(), 20); 
			btnSetScheduleTitle = new JButton("Set Title");
			btnSetScheduleTitle.addActionListener(this);
			
			JPanel pnlActions = new JPanel();
			pnlActions.setLayout(new GridLayout(3, 1));
			JPanel pnlAddRemove = new JPanel();
			pnlAddRemove.setLayout(new GridLayout(1, 2));
			pnlAddRemove.add(btnAddCourse);
			pnlAddRemove.add(btnNewCourse);
			pnlAddRemove.add(btnRemoveCourse);
			JPanel pnlResetDisplay = new JPanel();
			pnlResetDisplay.setLayout(new GridLayout(1, 2));
			pnlResetDisplay.add(btnReset);
			pnlResetDisplay.add(btnDisplay);
			JPanel pnlScheduleTitle = new JPanel();
			pnlScheduleTitle.setLayout(new GridLayout(1, 3));
			pnlScheduleTitle.add(lblScheduleTitle);
			pnlScheduleTitle.add(txtScheduleTitle);
			pnlScheduleTitle.add(btnSetScheduleTitle);
			pnlActions.add(pnlAddRemove);
			pnlActions.add(pnlResetDisplay);
			pnlActions.add(pnlScheduleTitle);
			
			Border lowerEtched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
			TitledBorder borderActions = BorderFactory.createTitledBorder(lowerEtched, "Actions");
			pnlActions.setBorder(borderActions);
			pnlActions.setToolTipText("Scheduler Actions");
						
			//Set up Catalog table
			catalogTableModel = new CourseTableModel(true);
			tableCatalog = new JTable(catalogTableModel) {
				private static final long serialVersionUID = 1L;
				
				/**
				 * Set custom tool tips for cells
				 * @param e MouseEvent that causes the tool tip
				 * @return tool tip text
				 */
				public String getToolTipText(MouseEvent e) {
					java.awt.Point p = e.getPoint();
					int rowIndex = rowAtPoint(p);
					int colIndex = columnAtPoint(p);
					int realColumnIndex = convertColumnIndexToModel(colIndex);
					
					return (String)catalogTableModel.getValueAt(rowIndex, realColumnIndex);
				}
			};
			tableCatalog.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			tableCatalog.setPreferredScrollableViewportSize(new Dimension(500, 500));
			tableCatalog.setFillsViewportHeight(true);
			tableCatalog.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

				@Override
				public void valueChanged(ListSelectionEvent e) {
					String name = tableCatalog.getValueAt(tableCatalog.getSelectedRow(), 0).toString();
					String section = tableCatalog.getValueAt(tableCatalog.getSelectedRow(), 1).toString();
					Course c = scheduler.getCourseFromCatalogue(name, section);
					updateCourseDetails(c);
				}
				
			});
			
			JScrollPane scrollCatalog = new JScrollPane(tableCatalog);
			
			TitledBorder borderCatalog = BorderFactory.createTitledBorder(lowerEtched, "Course Catalog");
			scrollCatalog.setBorder(borderCatalog);
			scrollCatalog.setToolTipText("Course Catalog");
			
			//Set up Schedule table
			scheduleTableModel = new CourseTableModel(false);
			tableSchedule = new JTable(scheduleTableModel);
			tableSchedule.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			tableSchedule.setPreferredScrollableViewportSize(new Dimension(500, 500));
			tableSchedule.setFillsViewportHeight(true);
			
			JScrollPane scrollSchedule = new JScrollPane(tableSchedule);
			
			borderSchedule = BorderFactory.createTitledBorder(lowerEtched, scheduler.getScheduleTitle());
			scrollSchedule.setBorder(borderSchedule);
			scrollSchedule.setToolTipText(scheduler.getScheduleTitle());
			
			updateTables();
			
			//Set up the course details panel
			pnlCourseDetails = new JPanel();
			pnlCourseDetails.setLayout(new GridLayout(4, 1));
			JPanel pnlName = new JPanel(new GridLayout(1, 4));
			pnlName.add(lblNameTitle);
			pnlName.add(lblName);
			pnlName.add(lblSectionTitle);
			pnlName.add(lblSection);
			
			JPanel pnlTitle = new JPanel(new GridLayout(1, 1));
			pnlTitle.add(lblTitleTitle);
			pnlTitle.add(lblTitle);
			
			JPanel pnlInstructor = new JPanel(new GridLayout(1, 2));
			pnlInstructor.add(lblInstructorTitle);
			pnlInstructor.add(lblInstructor);
			
			JPanel pnlMeeting = new JPanel(new GridLayout(1, 1));
			pnlMeeting.add(lblMeetingTitle);
			pnlMeeting.add(lblMeeting);
			
			pnlCourseDetails.add(pnlName);
			pnlCourseDetails.add(pnlTitle);
			pnlCourseDetails.add(pnlInstructor);
			pnlCourseDetails.add(pnlMeeting);
			
			TitledBorder borderCourseDetails = BorderFactory.createTitledBorder(lowerEtched, "Course Details");
			pnlCourseDetails.setBorder(borderCourseDetails);
			pnlCourseDetails.setToolTipText("Course Details");
			
			add(scrollCatalog);
			add(pnlActions);
			add(scrollSchedule);
			add(pnlCourseDetails);
		}

		/**
		 * Performs an action based on the given {@link ActionEvent}.
		 * @param e user event that triggers an action.
		 */
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnAddCourse) {
				int row = tableCatalog.getSelectedRow();
				if (row == -1  || row == tableCatalog.getRowCount()) {
					JOptionPane.showMessageDialog(PolarSchedulerUI.this, "No course selected in the catalog.");
				} else {
					try {
						if (!scheduler.addCourseToSchedule(tableCatalog.getValueAt(row, 0).toString(), tableCatalog.getValueAt(row, 1).toString())) {
							JOptionPane.showMessageDialog(PolarSchedulerUI.this, "Course doesn't exist.");
						}
					} catch (IllegalArgumentException iae) {
						JOptionPane.showMessageDialog(PolarSchedulerUI.this, iae.getMessage());
					}
				}
				updateTables();
			}
			else if (e.getSource() == btnNewCourse) {
				cardLayout.show(panel, ADD_COURSE_PANEL);
			}
			else if (e.getSource() == btnRemoveCourse) {
				int row = tableSchedule.getSelectedRow();
				if (row == -1 || row == tableSchedule.getRowCount()) {
					JOptionPane.showMessageDialog(PolarSchedulerUI.this, "No item selected in the schedule.");
				} else {
					scheduler.removeCourseFromSchedule(tableSchedule.getValueAt(row, 0).toString(), tableSchedule.getValueAt(row, 1).toString());
				}
				updateTables();
			} else if (e.getSource() == btnReset) {
				scheduler.resetSchedule();
				updateTables();
			} else if (e.getSource() == btnDisplay) {
				cardLayout.show(panel, SCHEDULE_PANEL);
				pnlSchedule.updateFinalizedTable();
			} else if (e.getSource() == btnSetScheduleTitle) {
				try {
					scheduler.setScheduleTitle(txtScheduleTitle.getText()); 
				} catch (IllegalArgumentException iae) {
					JOptionPane.showMessageDialog(PolarSchedulerUI.this, "Invalid title.");
				}
				borderSchedule.setTitle(scheduler.getScheduleTitle());
			}
			
			PolarSchedulerUI.this.repaint();
			PolarSchedulerUI.this.validate();
		}
		
		/**
		 * Updates the catalog and schedule tables.
		 */
		public void updateTables() {
			catalogTableModel.updateData();
			scheduleTableModel.updateData();
		}
		
		/**
		 * Updates the pnlCourseDetails with full information about the most
		 * recently selected course.
		 * @param c course to use as source of update
		 */
		private void updateCourseDetails(Course c) {
			if (c != null) {
				lblName.setText(c.getName());
				lblSection.setText(c.getSection());
				lblTitle.setText(c.getTitle());
				lblInstructor.setText(c.getInstructorId());
				lblMeeting.setText(c.getMeetingString());
			}
		}
		
		/**
		 * {@link CourseTableModel} is the object underlying the {@link JTable} object that displays
		 * the list of {@link Course}s to the user.
		 * @author Sarah Heckman
		 */
		private class CourseTableModel extends AbstractTableModel {
			
			/** ID number used for object serialization. */
			private static final long serialVersionUID = 1L;
			/** Column names for the table */
			private String [] columnNames = {"Name", "Section", "Title"};
			/** Data stored in the table */
			private Object [][] data;
			/** Boolean flag if the model applies to the catalog or schedule */
			private boolean catalog;
			
			/**
			 * Constructs the {@link CourseTableModel} by requesting the latest information
			 * from the {@link RequirementTrackerModel}.
			 * @param catalog flag to determine if updating the catalog (true) or schedule (false)
			 */
			public CourseTableModel(boolean catalog) {
				this.catalog = catalog;
				updateData();
			}

			/**
			 * Returns the number of columns in the table.
			 * @return the number of columns in the table.
			 */
			public int getColumnCount() {
				return columnNames.length;
			}

			/**
			 * Returns the number of rows in the table.
			 * @return the number of rows in the table.
			 */
			public int getRowCount() {
				if (data == null) 
					return 0;
				return data.length;
			}
			
			/**
			 * Returns the column name at the given index.
			 * @param col column index
			 * @return the column name at the given column.
			 */
			public String getColumnName(int col) {
				return columnNames[col];
			}

			/**
			 * Returns the data at the given {row, col} index.
			 * @param row row index
			 * @param col column index
			 * @return the data at the given location.
			 */
			public Object getValueAt(int row, int col) {
				if (data == null)
					return null;
				return data[row][col];
			}
			
			/**
			 * Sets the given value to the given {row, col} location.
			 * @param value Object to modify in the data.
			 * @param row location to modify the data.
			 * @param col location to modify the data.
			 */
			public void setValueAt(Object value, int row, int col) {
				data[row][col] = value;
				fireTableCellUpdated(row, col);
			}
			
			/**
			 * Updates the given model with {@link Course} information from the {@link WolfScheduler}.
			 */
			public void updateData() {
				if (catalog) {
					data = scheduler.getCourseCatalogue();
				} else {
					data = scheduler.getScheduledCourses();
				}
			}
		}
	}
	
	
	private class AddCoursePanel extends JPanel implements ActionListener {
		
		private static final long serialVersionUID = 2063299973324635304L;
		private JPanel pnlCourseDetails;
		
		/** Label for Course Details name title */
		private JLabel lblNameTitle = new JLabel("Name: ");
		/** Label for Course Details section title */
		private JLabel lblSectionTitle = new JLabel("Section: ");
		/** Label for Course Details title title */
		private JLabel lblTitleTitle = new JLabel("Title: ");
		/** Label for Course Details instructor title */
		private JLabel lblInstructorTitle = new JLabel("Instructor: ");
		/** Label for Course Details start time title */
		private JLabel lblStartTimeTitle = new JLabel("Start Time: ");
		/** Label for Course Details end time title */
		private JLabel lblEndTimeTitle = new JLabel("End Time: ");
		/** Label for Course Details meeting days title */
		private JLabel lblMeetingDaysTitle = new JLabel("Meeting Days: ");
		
		private static final int TEXT_FIELD_LENGTH = 15;
		
		private JTextField txtName = new JTextField(TEXT_FIELD_LENGTH);
		
		private JTextField txtSection = new JTextField(TEXT_FIELD_LENGTH);
		
		private JTextField txtTitle = new JTextField(TEXT_FIELD_LENGTH);
		
		private JTextField txtInstructor = new JTextField(TEXT_FIELD_LENGTH);
		
		private JTextField txtStartTime = new JTextField(TEXT_FIELD_LENGTH);
		
		private JTextField txtEndTime = new JTextField(TEXT_FIELD_LENGTH);
		
		private JTextField txtMeetingDays = new JTextField(TEXT_FIELD_LENGTH);
		
		private JButton btnAddCourse = new JButton("Add Course");
		
		private JButton btnResetAddCourse = new JButton("Reset");
		
		private JLabel lblAddCourseMessage = new JLabel();
		
		private JButton btnReturn = new JButton ("Return to Course Catalogue");
		
		
		public AddCoursePanel() {
			super();
			pnlCourseDetails = new JPanel();
			pnlCourseDetails.setLayout(new GridLayout(12, 1));
			
			JPanel pnlName = new JPanel(new GridLayout(1,1));
			pnlName.add(lblNameTitle);
			pnlName.add(txtName);
			
			
			JPanel pnlSection = new JPanel(new GridLayout(1,1));
			pnlSection.add(lblSectionTitle);
			pnlSection.add(txtSection);
			
			
			JPanel pnlTitle = new JPanel(new GridLayout(1,1));
			pnlTitle.add(lblTitleTitle);
			pnlTitle.add(txtTitle);
			
			JPanel pnlInstructor = new JPanel(new GridLayout(1,1));
			pnlInstructor.add(lblInstructorTitle);
			pnlInstructor.add(txtInstructor);
			
			JPanel pnlStartTime = new JPanel(new GridLayout(1,1));
			pnlStartTime.add(lblStartTimeTitle);
			pnlStartTime.add(txtStartTime);
			
			JPanel pnlEndTime = new JPanel(new GridLayout(1,1));
			pnlEndTime.add(lblEndTimeTitle);
			pnlEndTime.add(txtEndTime);
			
			JPanel pnlMeetingDays = new JPanel(new GridLayout(1,1));
			pnlMeetingDays.add(lblMeetingDaysTitle);
			pnlMeetingDays.add(txtMeetingDays);
			
			
			JPanel buttons = new JPanel(new GridLayout(1,2));
			buttons.add(btnAddCourse);
			buttons.add(btnResetAddCourse);
			btnAddCourse.addActionListener(this);
			btnResetAddCourse.addActionListener(this);
			
			JPanel message = new JPanel(new GridLayout(1,1));
			message.add(lblAddCourseMessage);
			
			JPanel pnlReturn = new JPanel(new GridLayout(1,1));
			
			pnlReturn.add(btnReturn);
			btnReturn.addActionListener(this);
			
			
			pnlCourseDetails.add(pnlName);
			pnlCourseDetails.add(pnlSection);
			pnlCourseDetails.add(pnlTitle);
			pnlCourseDetails.add(pnlInstructor);
			pnlCourseDetails.add(pnlStartTime);
			pnlCourseDetails.add(pnlEndTime);
			pnlCourseDetails.add(pnlMeetingDays);
			
			pnlCourseDetails.add(buttons);
			pnlCourseDetails.add(message);
			pnlCourseDetails.add(pnlReturn);
			
			
			
			Border lowerEtched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
			
			TitledBorder borderCourseDetails = BorderFactory.createTitledBorder(lowerEtched, "New Course Details");
			pnlCourseDetails.setBorder(borderCourseDetails);
			pnlCourseDetails.setToolTipText("Enter New Course Details");
			
//			
//			pnlCourseDetails.add(lblSectionTitle);
//			pnlCourseDetails.add(lblTitleTitle);
//			pnlCourseDetails.add(lblInstructorTitle);
//			pnlCourseDetails.add(lblMeetingTitle);
//			
			
			add(pnlCourseDetails);
			
			
			
		}
		

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnAddCourse) {
				String name = txtName.getText();
				String section = txtSection.getText();
				String title = txtTitle.getText();
				String instructor = txtInstructor.getText();
				String startTime = txtStartTime.getText();
				String endTime = txtEndTime.getText();
				String meetingDays = txtMeetingDays.getText();
				
				try {
					scheduler.createNewCourse(name, title, section, instructor, meetingDays, startTime, endTime);
					lblAddCourseMessage.setText("Course added successfully");
                    resetFields();
				}
				catch (IllegalArgumentException iae) {
					lblAddCourseMessage.setText(iae.getMessage());
				}

			}
			
			else if (e.getSource() == btnResetAddCourse) {
                resetFields();
			}
			else if (e.getSource() == btnReturn) {
				pnlScheduler.updateTables();
				lblAddCourseMessage.setText(null);
				cardLayout.show(panel, SCHEDULER_PANEL);
			}
		}
		
		private void resetFields() {
			txtEndTime.setText(null);
			txtInstructor.setText(null);
			txtMeetingDays.setText(null);
			txtName.setText(null);
			txtSection.setText(null);
			txtStartTime.setText(null);
			txtTitle.setText(null);
		}
		
	}
	
	
	
	/**
	 * Inner class that creates the look and behavior for the {@link JPanel} that 
	 * shows the list of requirements.
	 * 
	 * @author Sarah Heckman 
	 */
	private class SchedulePanel extends JPanel implements ActionListener {
		/** ID number used for object serialization. */
		private static final long serialVersionUID = 1L;
		/** Button for adding the selected course in the catalog to the schedule */
		private JButton btnReviseSchedule;
		/** JTable for displaying the schedule of Courses */
		private JTable tableSchedule;
		/** TableModel for schedule */
		private FullCourseTableModel scheduleTableModel;
		/** Scroll pane for setting table title */
		private JScrollPane scrollSchedule;
		/** Border for schedule */
		private TitledBorder borderSchedule;
		
		/**
		 * Constructs the Schedule Panel
		 */
		public SchedulePanel() {
			super(new GridLayout(4, 1));
			
			//Set up action buttons
			btnReviseSchedule = new JButton("Revise Schedule");
			btnReviseSchedule.addActionListener(this);
			JPanel pnlActions = new JPanel();
			pnlActions.setLayout(new GridLayout(1, 2));
			pnlActions.add(btnReviseSchedule);
			
			Border lowerEtched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
			TitledBorder borderActions = BorderFactory.createTitledBorder(lowerEtched, "Actions");
			pnlActions.setBorder(borderActions);
			pnlActions.setToolTipText("Schedule Actions");
			
			//Set up Schedule table
			scheduleTableModel = new FullCourseTableModel();
			tableSchedule = new JTable(scheduleTableModel);
			tableSchedule.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			tableSchedule.setPreferredScrollableViewportSize(new Dimension(500, 500));
			tableSchedule.setFillsViewportHeight(true);
			tableSchedule.getColumnModel().getColumn(0).setPreferredWidth(30);
			tableSchedule.getColumnModel().getColumn(1).setPreferredWidth(30);
			tableSchedule.getColumnModel().getColumn(2).setPreferredWidth(250);
			tableSchedule.getColumnModel().getColumn(3).setPreferredWidth(50);
			tableSchedule.getColumnModel().getColumn(4).setPreferredWidth(100);
			
			scrollSchedule = new JScrollPane(tableSchedule);
			
			borderSchedule = BorderFactory.createTitledBorder(lowerEtched, scheduler.getScheduleTitle());
			scrollSchedule.setBorder(borderSchedule);
			scrollSchedule.setToolTipText(scheduler.getScheduleTitle());
			
			updateFinalizedTable();
			
			add(pnlActions);
			add(scrollSchedule);
		}
		
		/**
		 * Performs an action based on the given {@link ActionEvent}.
		 * @param e user event that triggers an action.
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnReviseSchedule) {
				cardLayout.show(panel, SCHEDULER_PANEL);
			} 
		}
		
		/**
		 * Updates the finalized schedule table
		 */
		public void updateFinalizedTable() {
			scheduleTableModel.updateData();
			borderSchedule.setTitle(scheduler.getScheduleTitle());
			scrollSchedule.setToolTipText(scheduler.getScheduleTitle());
		}
		
		/**
		 * {@link FullCourseTableModel} is the object underlying the {@link JTable} object that displays
		 * the list of {@link Course}s, and all their data, to the user.
		 * @author Sarah Heckman
		 */
		private class FullCourseTableModel extends AbstractTableModel {
			
			/** ID number used for object serialization. */
			private static final long serialVersionUID = 1L;
			/** Column names for the table */
			private String [] columnNames = {"Name", "Section", "Title", "Instructor", "Meeting Time"};
			/** Data stored in the table */
			private Object [][] data;
			
			/**
			 * Constructs the {@link CourseTableModel} by requesting the latest information
			 * from the {@link RequirementTrackerModel}.
			 */
			public FullCourseTableModel() {
				updateData();
			}

			/**
			 * Returns the number of columns in the table.
			 * @return the number of columns in the table.
			 */
			public int getColumnCount() {
				return columnNames.length;
			}

			/**
			 * Returns the number of rows in the table.
			 * @return the number of rows in the table.
			 */
			public int getRowCount() {
				if (data == null) 
					return 0;
				return data.length;
			}
			
			/**
			 * Returns the column name at the given index.
			 * @param col column index
			 * @return the column name at the given column.
			 */
			public String getColumnName(int col) {
				return columnNames[col];
			}

			/**
			 * Returns the data at the given {row, col} index.
			 * @param row row index
			 * @param col column index
			 * @return the data at the given location.
			 */
			public Object getValueAt(int row, int col) {
				if (data == null)
					return null;
				return data[row][col];
			}
			
			/**
			 * Sets the given value to the given {row, col} location.
			 * @param value Object to modify in the data.
			 * @param row location to modify the data.
			 * @param col location to modify the data.
			 */
			public void setValueAt(Object value, int row, int col) {
				data[row][col] = value;
				fireTableCellUpdated(row, col);
			}
			
			/**
			 * Updates the given model with {@link Course} information from the {@link WolfScheduler}.
			 */
			private void updateData() {
				data = scheduler.getFullScheduledCourses();
			}
		}
		
	}
}