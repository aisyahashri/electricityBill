package com.example.electricitybill.ui.electricitybill;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.electricitybill.R;

public class BillCalculationFragment extends Fragment {

    private EditText edtUnits, edtRebate;
    private Button btnCalculate, btnClear;
    private TextView txtResult;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bill_calculation, container, false);

        // Set the toolbar title to Electric Voltage
        requireActivity().setTitle(R.string.app_name);

        // Initialize views
        edtUnits = view.findViewById(R.id.edtUnits);
        edtRebate = view.findViewById(R.id.edtRebate);
        btnCalculate = view.findViewById(R.id.btnCalculate);
        btnClear = view.findViewById(R.id.btnClear);
        txtResult = view.findViewById(R.id.txtResult);

        // Set the click listener for the calculate button
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBill();
            }
        });

        // Set the click listener for the clear button
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearFields();
            }
        });

        return view;
    }

    private void calculateBill() {
        String unitsInput = edtUnits.getText().toString();
        String rebateInput = edtRebate.getText().toString();

        if (unitsInput.isEmpty() || rebateInput.isEmpty()) {
            txtResult.setText("Please enter both fields.");
            return;
        }

        int units = Integer.parseInt(unitsInput);
        double rebate = Double.parseDouble(rebateInput);

        // Validate rebate percentage
        if (rebate < 0 || rebate > 5) {
            txtResult.setText("Rebate percentage must be between 0% and 5%.");
            return;
        }

        // Initialize total cost
        double totalCost = 0;

        // Calculate cost based on blocks
        if (units <= 200) {
            totalCost = units * 0.218;
        } else if (units <= 300) {
            totalCost = (200 * 0.218) + ((units - 200) * 0.334);
        } else if (units <= 600) {
            totalCost = (200 * 0.218) + (100 * 0.334) + ((units - 300) * 0.516);
        } else {
            totalCost = (200 * 0.218) + (100 * 0.334) + (300 * 0.516) + ((units - 600) * 0.546);
        }

        // Apply rebate
        double rebateAmount = totalCost * (rebate / 100);
        double finalCost = totalCost - rebateAmount;

        // Display result
        txtResult.setText(String.format("Total Charges: RM%.2f\nAfter Rebate: RM%.2f", totalCost, finalCost));
    }

    private void clearFields() {
        // Clear all inputs and reset the result
        edtUnits.setText("");
        edtRebate.setText("");
        txtResult.setText("");
    }
}
