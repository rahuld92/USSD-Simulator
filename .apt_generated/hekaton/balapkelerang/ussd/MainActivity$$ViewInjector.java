// Generated code from Butter Knife. Do not modify!
package hekaton.balapkelerang.ussd;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class MainActivity$$ViewInjector {
  public static void inject(Finder finder, final hekaton.balapkelerang.ussd.MainActivity target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131099669, "field 'request'");
    target.request = (android.widget.EditText) view;
    view = finder.findRequiredView(source, 2131099668, "field 'response'");
    target.response = (android.widget.TextView) view;
    view = finder.findRequiredView(source, 2131099648, "field 'display'");
    target.display = (android.widget.TextView) view;
    view = finder.findRequiredView(source, 2131099664, "field 'progressDialog'");
    target.progressDialog = view;
    view = finder.findRequiredView(source, 2131099667, "field 'ussdPanel'");
    target.ussdPanel = view;
    view = finder.findRequiredView(source, 2131099663, "field 'layer'");
    target.layer = view;
    view = finder.findRequiredView(source, 2131099671, "method 'buttonSend'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.buttonSend((android.widget.Button) p0);
        }
      });
    view = finder.findRequiredView(source, 2131099659, "method 'buttonPress'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.buttonPress((android.widget.Button) p0);
        }
      });
    view = finder.findRequiredView(source, 2131099649, "method 'buttonPress'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.buttonPress((android.widget.Button) p0);
        }
      });
    view = finder.findRequiredView(source, 2131099650, "method 'buttonPress'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.buttonPress((android.widget.Button) p0);
        }
      });
    view = finder.findRequiredView(source, 2131099651, "method 'buttonPress'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.buttonPress((android.widget.Button) p0);
        }
      });
    view = finder.findRequiredView(source, 2131099652, "method 'buttonPress'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.buttonPress((android.widget.Button) p0);
        }
      });
    view = finder.findRequiredView(source, 2131099653, "method 'buttonPress' and method 'setNumber'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.buttonPress((android.widget.Button) p0);
        }
      });
    view.setOnLongClickListener(
      new android.view.View.OnLongClickListener() {
        @Override public boolean onLongClick(
          android.view.View p0
        ) {
          return target.setNumber((android.widget.Button) p0);
        }
      });
    view = finder.findRequiredView(source, 2131099654, "method 'buttonPress'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.buttonPress((android.widget.Button) p0);
        }
      });
    view = finder.findRequiredView(source, 2131099655, "method 'buttonPress'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.buttonPress((android.widget.Button) p0);
        }
      });
    view = finder.findRequiredView(source, 2131099656, "method 'buttonPress' and method 'setURL'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.buttonPress((android.widget.Button) p0);
        }
      });
    view.setOnLongClickListener(
      new android.view.View.OnLongClickListener() {
        @Override public boolean onLongClick(
          android.view.View p0
        ) {
          return target.setURL((android.widget.Button) p0);
        }
      });
    view = finder.findRequiredView(source, 2131099657, "method 'buttonPress'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.buttonPress((android.widget.Button) p0);
        }
      });
    view = finder.findRequiredView(source, 2131099660, "method 'buttonSharp'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.buttonSharp((android.widget.Button) p0);
        }
      });
    view = finder.findRequiredView(source, 2131099662, "method 'buttonBackspace' and method 'buttonLongBackspace'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.buttonBackspace((android.widget.Button) p0);
        }
      });
    view.setOnLongClickListener(
      new android.view.View.OnLongClickListener() {
        @Override public boolean onLongClick(
          android.view.View p0
        ) {
          return target.buttonLongBackspace((android.widget.Button) p0);
        }
      });
    view = finder.findRequiredView(source, 2131099670, "method 'buttonCancel'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.buttonCancel();
        }
      });
    view = finder.findRequiredView(source, 2131099658, "method 'buttonStar'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.buttonStar((android.widget.Button) p0);
        }
      });
    view = finder.findRequiredView(source, 2131099661, "method 'buttonCall'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.buttonCall((android.widget.Button) p0);
        }
      });
  }

  public static void reset(hekaton.balapkelerang.ussd.MainActivity target) {
    target.request = null;
    target.response = null;
    target.display = null;
    target.progressDialog = null;
    target.ussdPanel = null;
    target.layer = null;
  }
}
