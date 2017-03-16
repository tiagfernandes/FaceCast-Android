package org.btssio.slam.facecast2.adapters;

import android.app.Activity;
import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.btssio.slam.facecast2.R;
import org.btssio.slam.facecast2.objects.Postulation;

import java.util.List;

public class ListPostulationAdapter extends ArrayAdapter<Postulation> {
    private Activity activity;
    private List<Postulation> items;
    private Postulation objBean;
    private int row;

    public ListPostulationAdapter(Activity act, int resource, List<Postulation> arrayList) {
        super(act, resource, arrayList);
        this.activity = act;
        this.row = resource;
        this.items = arrayList;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = convertView;
        ViewHolder holder;

        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(row, null);

            holder = new ListPostulationAdapter.ViewHolder();
            view.setTag(holder);
        } else {
            holder = (ListPostulationAdapter.ViewHolder) view.getTag();
        }

        if ((items == null) || ((position + 1) > items.size()))
            return view;

        objBean = items.get(position);

        holder.nomEvent = (TextView) view.findViewById(R.id.nomEvent);
        holder.type = (TextView) view.findViewById(R.id.typeEvent);
        holder.date = (TextView) view.findViewById(R.id.dateEvent);
        holder.nombreJours = (TextView) view.findViewById(R.id.nombreJoursEvent);
        holder.nomRole = (TextView) view.findViewById(R.id.nomRole);
        holder.nbRoles = (TextView) view.findViewById(R.id.nbRoles);
        holder.etat = (TextView) view.findViewById(R.id.etat);

        if (holder.nomEvent != null && null != objBean.getNomEvent()
                && objBean.getNomEvent().trim().length() > 0) {
            holder.nomEvent.setText(Html.fromHtml(objBean.getNomEvent()));
        }

        if (holder.type != null && null != objBean.getTypeEvent()
                && objBean.getTypeEvent().trim().length() > 0) {
            holder.type.setText(Html.fromHtml(objBean.getTypeEvent()));
        }

        if (holder.date != null && null != objBean.getDateEvent()
                && objBean.getDateEvent().trim().length() > 0) {
            holder.date.setText(Html.fromHtml(objBean.getDateEvent()));
        }

        if (holder.nombreJours != null && null != objBean.getNombreJoursEvent()
                && objBean.getNombreJoursEvent().trim().length() > 0) {
            holder.nombreJours.setText(Html.fromHtml(objBean.getNombreJoursEvent()));
        }

        if (holder.nomRole != null && null != objBean.getNomRole()
                && objBean.getNomRole().trim().length() > 0) {
            holder.nomRole.setText(Html.fromHtml(objBean.getNomRole()));
        }

        if (holder.nbRoles != null && null != objBean.getNbRoles()
                && objBean.getNbRoles().trim().length() > 0) {
            holder.nbRoles.setText(Html.fromHtml(objBean.getNbRoles()));
        }

        if (holder.etat != null && null != objBean.getEtat()
                && objBean.getEtat().trim().length() > 0) {
            holder.etat.setText(Html.fromHtml(objBean.getEtat()));
        }
        return view;
    }

    public class ViewHolder {
        public TextView nomEvent, type, date, nombreJours, nomRole, nbRoles, etat;
    }
}