
document.writeln("<div class=\"vote mt1\">");
document.writeln(" <dl class=\"tbox\">");
document.writeln(" <dt><strong>投票调查</strong></dt>");
document.writeln("<form name=\'voteform\' method=\'post\' action=\'/plus/vote.php\' target=\'_blank\'>");
document.writeln("<input type=\'hidden\' name=\'dopost\' value=\'send\' />");
document.writeln("<input type=\'hidden\' name=\'aid\' value=\'2\' />");
document.writeln("<input type=\'hidden\' name=\'ismore\' value=\'0\' />");
document.writeln(" <dd> <strong>你感觉新主页与旧主页哪个好？</strong> ");
document.writeln(" <div class=\"fb\">");
document.writeln(" <input type=\'radio\' name=\'voteitem\' value=\'1\' />新的主页好");
document.writeln(" </div>");
document.writeln(" <div class=\"fb\">");
document.writeln(" <input type=\'radio\' name=\'voteitem\' value=\'2\' />旧的主页好");
document.writeln(" </div>");
document.writeln(" <div class=\"fb\">");
document.writeln(" <input type=\'radio\' name=\'voteitem\' value=\'3\' />都差不多");
document.writeln(" </div>");
