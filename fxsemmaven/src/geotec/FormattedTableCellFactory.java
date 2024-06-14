/*
 * Copyright (C) 2024 Gabriel Gomes Rodrigues Cheim <gabrielgrcheim2@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package geotec;

import java.text.NumberFormat;

/**
 * 
 * @author Gabriel Gomes Rodrigues Cheim <gabrielgrcheim2@gmail.com>
 * @date 13/06/2024
 * @brief Class FormattedTableCellFactory
 */
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;

import java.text.NumberFormat;
import java.util.Locale;

public class FormattedTableCellFactory<S> implements Callback<TableColumn<S, Double>, TableCell<S, Double>> {
    private final NumberFormat numberFormat;

    public FormattedTableCellFactory(NumberFormat numberFormat) {
        this.numberFormat = numberFormat;
    }

    @Override
    public TableCell<S, Double> call(TableColumn<S, Double> param) {
        return new TableCell<>() {
            @Override
            protected void updateItem(Double item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                } else {
                    setText(numberFormat.format(item));
                }
            }
        };
    }
}
