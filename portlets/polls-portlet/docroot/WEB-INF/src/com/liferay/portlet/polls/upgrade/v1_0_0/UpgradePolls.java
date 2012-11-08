/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This file is part of Liferay Social Office. Liferay Social Office is free
 * software: you can redistribute it and/or modify it under the terms of the GNU
 * Affero General Public License as published by the Free Software Foundation,
 * either version 3 of the License, or (at your option) any later version.
 *
 * Liferay Social Office is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU Affero General Public License
 * for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * Liferay Social Office. If not, see http://www.gnu.org/licenses/agpl-3.0.html.
 */

package com.liferay.portlet.polls.upgrade.v1_0_0;

import com.liferay.portal.kernel.upgrade.UpgradeProcess;

import java.sql.SQLException;

/**
 * @author Juan Fernández
 */
public class UpgradePolls extends UpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		if (hasTable("PollsChoice")) {
			if (hasTable("Polls_PollsChoice")) {
				runSQL("drop table Polls_PollsChoice");
			}

			try {
				runSQL("alter_table_name PollsChoice Polls_PollsChoice");
			}
			catch (SQLException sqle) {
				upgradeTable(
					"PollsChoice", PollsChoiceTable.TABLE_COLUMNS,
					PollsChoiceTable.TABLE_SQL_CREATE,
					PollsChoiceTable.TABLE_SQL_ADD_INDEXES);
			}
		}

		if (hasTable("PollsQuestion")) {
			if (hasTable("Polls_PollsQuestion")) {
				runSQL("drop table Polls_PollsQuestion");
			}

			try {
				runSQL("alter_table_name PollsQuestion Polls_PollsQuestion");
			}
			catch (SQLException sqle) {
				upgradeTable(
					"PollsQuestion", PollsQuestionTable.TABLE_COLUMNS,
					PollsQuestionTable.TABLE_SQL_CREATE,
					PollsQuestionTable.TABLE_SQL_ADD_INDEXES);
			}
		}

		if (hasTable("PollsVote")) {
			if (hasTable("Polls_PollsVote")) {
				runSQL("drop table Polls_PollsVote");
			}

			try {
				runSQL("alter_table_name PollsVote Polls_PollsVote");
			}
			catch (SQLException sqle) {
				upgradeTable(
					"PollsVote", PollsVoteTable.TABLE_COLUMNS,
					PollsVoteTable.TABLE_SQL_CREATE,
					PollsVoteTable.TABLE_SQL_ADD_INDEXES);
			}
		}
	}

}